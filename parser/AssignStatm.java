package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class AssignStatm extends Statement{

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<AssignStatm> on line " + lineNum;
    } /* End of identify */

    //TODO: prettyPrint?

    public static AssignStatm parse(Scanner s) {
        enterParser("assign statm");

        s.test(nameToken);
        s.skip(assignToken);
        // create an expression and return it

        leaveParser("assign statm");
        return null;
    }/*End parse*/

} /* End of class */
