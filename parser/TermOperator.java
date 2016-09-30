package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class TermOperator extends Operator{

    public TermOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    public static TermOperator parse(Scanner s) {
        enterParser("term operator");
        leaveParser("term operator");
        return null;
    }/*End parse*/

    //TODO: prettyPrint?
}/*End class*/
