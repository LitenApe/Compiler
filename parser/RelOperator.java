package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class RelOperator extends Operator{

    public static TokenKind[] operators = {equalToken,notEqualToken,lessToken,
                                           lessEqualToken,greaterToken,greaterEqualToken};

    public RelOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<RelOperator> on line " + lineNum;
    } /* End of identify */

    public static RelOperator parse(Scanner s) {
        enterParser("rel operator");
        leaveParser("rel operator");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint() {
    }
}/*End class*/
