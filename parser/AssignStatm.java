package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class AssignStatm extends Statement{
    private static Expression ex;

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
        AssignStatm as = new AssignStatm(s.curLineNum());
        ex = new Expression(s.curLineNum());

        leaveParser("assign statm");
        return as;
    }/*End parse*/

} /* End of class */
