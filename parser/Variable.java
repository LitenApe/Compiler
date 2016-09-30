package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Variable extends Factor{

    public Variable(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Variable> on line " + lineNum;
    } /* End of identify */

    public static Variable parse(Scanner s) {
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
