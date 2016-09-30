package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class SimpleExpr extends PascalSyntax{

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override public String identify() {
        return "<SimpleExpr> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static SimpleExpr parse(Scanner s){
        enterParser("simple expr");
        leaveParser("simple expr");
        return null;
    }
}/*End class*/
