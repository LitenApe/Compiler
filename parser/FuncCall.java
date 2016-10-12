package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FuncCall extends Factor{

    // name : ( : expression : , : )

    NamedConst name = null;
    Expression expression = null;

    public FuncCall(int n){
        super(n);
    }/*End constructor*/

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
                fCall.expression = Expression.parse(s);
                if(s.curToken.kind != commaToken){
                    break;
                }
                s.skip(commaToken);
            }
            s.skip(rightParToken);
        }

        leaveParser("func call");
        return fCall;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/


}/*End class*/
