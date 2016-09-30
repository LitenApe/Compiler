package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FuncCall extends Factor{

    public FuncCall(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<FuncCall> on line " + lineNum;
    } /* End of identify */

    public static FuncCall parse(Scanner s) {
        enterParser("func call");
        leaveParser("func call");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/


}/*End class*/
