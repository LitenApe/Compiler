package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.Main;

public class FuncCall extends Factor{

    // name : ( : expression : , : )

    NamedConst name = null;
    ArrayList<Expression> expressions = new ArrayList<>();

    public FuncCall(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Func Call");
        // name.check(curScope,lib);
        // for (Expression e : expressions)
        //     e.check(curScope,lib);
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
        return "<FuncCall> on line " + lineNum;
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
