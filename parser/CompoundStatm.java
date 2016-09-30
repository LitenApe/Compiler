package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class CompoundStatm extends Statement{

    public CompoundStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    public static CompoundStatm parse(Scanner s) {
        enterParser("compound statm");
        leaveParser("compound statm");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
