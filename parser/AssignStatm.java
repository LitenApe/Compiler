package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class AssignStatm extends Statement{

    // variable : := : expression

    public static Variable variable = null;
    public static Expression expression = null;

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void prettyPrint(){
        System.out.println("assign statment");
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<AssignStatm> on line " + lineNum;
    } /* End of identify */

    //TODO: prettyPrint?

    public static AssignStatm parse(Scanner s) {
        enterParser("assign statm");

        AssignStatm as = new AssignStatm(s.curLineNum());

        as.variable = Variable.parse(s);
        s.skip(assignToken);
        as.expression = Expression.parse(s);

        leaveParser("assign statm");
        return as;
    }/*End parse*/

} /* End of class */
