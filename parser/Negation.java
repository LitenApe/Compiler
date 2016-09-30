package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Negation extends Factor{

    public Negation(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Negation> on line " + lineNum;
    } /* End of identify */

    public static Negation parse(Scanner s) {
        enterParser("negation");
        leaveParser("negation");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
