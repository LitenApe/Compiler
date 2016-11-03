package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.Main;

public class FuncCall extends Factor{

    // name : ( : expression : , : )

    NamedConst name = null;
    ArrayList<Expression> expressions = new ArrayList<>();
    FuncDecl decl = null;
    ArrayList<ParamDecl> declParameters = null;

    public FuncCall(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[-] Func Call: " + name.name);
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
