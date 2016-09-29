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

    //TODO: PRettyrpint?

    public static Statement parse(Scanner s) {
        return null;
    }/*End parse*/
}/*End class*/
