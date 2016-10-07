package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class AssignStatm extends Statement{

    // variable : := : expression

    public static Variable varb = null;
    public static Expression ex;

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

        AssignStatm as = new AssignStatm(s.curLineNum());

        s.test(nameToken);
        as.varb = Variable.parse(s);

        s.skip(assignToken);

        s.test(nameToken)
        ex = new Expression(s.curLineNum());

        leaveParser("assign statm");
        return as;
    }/*End parse*/

} /* End of class */
