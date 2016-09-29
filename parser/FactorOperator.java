package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FactorOperator extends Operator{

    public FactorOperator(){
        super();
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<FactorOperator> on line " + lineNum;
    } /* End of identify */

    public static FactorOperator parse(Scanner s) {
        return null;
    }/*End parse*/

    //TODO: Prettyprint?
    
}/*End class*/
