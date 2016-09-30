package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class IfStatm extends Statement{

    public IfStatm(int n){
        super(n);
    } /* End of public */

    @Override public String identify() {
        return "<IfStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {

    }

    public static IfStatm parse(Scanner s) {
        enterParser("if statm");
        leaveParser("if statm");
        return null;
    }/*End parse*/

} /* End of class */
