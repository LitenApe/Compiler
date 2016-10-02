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
        enterParser("factor");

        //TODO: Factor is hard. puta.

        leaveParser("factor");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

}/*End class*/
