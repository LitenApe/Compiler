package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.*;

public class FuncCall extends Factor{

    // name : ( : expression : , : )

    NamedConst name = null;
    ArrayList<Expression> expressions = new ArrayList<>();
    ArrayList<ParamDecl> declParameters = null; //actually local(?)
    FuncDecl decl = null;

    public FuncCall(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-x?] Function Call");

        for (int i = expressions.size()-1; i >= 0; i--){
            expressions.get(i).genCode(f);
            f.genInstr("","pushl","%eax","Push param #"+(i+1));
        }
        f.genInstr("","call","func$"+decl.label,"");
        f.genInstr("","addl","$"+(expressions.size()*4)+",%esp","Pop parameters");
    }

    @Override
    public void check(Block curScope, Library lib){
        name.check(curScope,lib);

        decl = (FuncDecl) curScope.findDecl(name.name, this);
        declParameters = decl.getParams().listOfParamDecls;

        for (Expression e : expressions){
            e.check(curScope,lib);
            type = declParameters.get(expressions.indexOf(e)).type;
            type.checkType(type, "param "+"#"+(expressions.indexOf(e)+1), this, "parameter not same!"); //NOTE:
        }
    }

    @Override
    public void prettyPrint(){
        name.prettyPrint();
        if (!expressions.isEmpty()){
            Main.log.prettyPrint("(");
            for (Expression e : expressions){
                e.prettyPrint();
                if (e != expressions.get(expressions.size()-1)){
                    Main.log.prettyPrint(", ");
                }
            }
            Main.log.prettyPrint(")");
        }
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<func call> on line " + lineNum;
    } /* End of identify */

    public static FuncCall parse(Scanner s) {
        enterParser("func call");

        FuncCall fCall = new FuncCall(s.curLineNum());
        fCall.name = NamedConst.parse(s);
        if(s.curToken.kind == leftParToken){
            s.skip(leftParToken);
            while(true){
                fCall.expressions.add(Expression.parse(s));
                if(s.curToken.kind != commaToken){
                    break; //TODO: ERROR
                }else{
                    s.skip(commaToken);
                }
            }
            s.skip(rightParToken);
        }

        leaveParser("func call");
        return fCall;
    }/*End parse*/
}/*End class*/
