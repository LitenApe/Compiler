package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class PrefixOperator extends Operator{

    public PrefixOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<PrefixOperator> on line " + lineNum;
    } /* End of identify */

    public static PrefixOperator parse(Scanner s) {
        enterParser("prefix operator");
        leaveParser("prefix operator");
        return null;
    }/*End parse*/

    //TODO: prettyPrint?

}/*End class*/
