package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class Factor extends PascalSyntax{

    public Factor(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Factor> on line " + lineNum;
    } /* End of identify */

    public static Factor parse(Scanner s) {
        return null;
    }/*End parse*/

    //TODO:prettyPrint?
    
}/*End class*/
