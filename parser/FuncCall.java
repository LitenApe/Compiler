package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FuncCall extends Factor{
    String name = "";
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
        s.skip(leftParToken);
        while(s.curToken.kind != rightParToken){
            System.out.println("wuut");
            fCall.expression = Expression.parse(s);
            s.skip(commaToken);
        }
        s.skip(rightParToken);
        leaveParser("func call");
        return fCall;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/


}/*End class*/
