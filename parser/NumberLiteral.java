package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class NumberLiteral extends UnsignedConstant{

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<NumberLiteral> on line " + lineNum;
    } /* End of identify */

    public static NumberLiteral parse(Scanner s) {
        enterParser("number literal");
        leaveParser("number literal");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
