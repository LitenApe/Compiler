package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class SimpleExpr{
    public SimpleExpr(){

    }/*End Constructor*/

    @Override public String identify() {
        return "<SimpleExpr> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
