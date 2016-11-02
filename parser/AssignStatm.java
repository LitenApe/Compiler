package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class AssignStatm extends Statement{

    // variable : := : expression

    public Variable variable = null;
    public Expression expression = null;

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[-] Assign Statment");

        variable.check(curScope,lib);
        expression.check(curScope,lib);
    }

    @Override
    public void prettyPrint(){
        variable.prettyPrint();
        Main.log.prettyPrint(" := ");
        expression.prettyPrint();
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<assign statm> on line " + lineNum;
    } /* End of identify */

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
