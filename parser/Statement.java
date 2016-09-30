package parser;

import scanner.*;
import static scanner.TokenKind.*;

public abstract class Statement extends PascalSyntax{

    public Statement(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Statement> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static Statement parse(Scanner s) {
        enterParser("statement");
        leaveParser("statement");
        return null;
    }/*End parse*/
}/*End class*/
