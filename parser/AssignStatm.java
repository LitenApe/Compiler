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
        variable.check(curScope,lib);
        expression.check(curScope,lib);

        if(variable.decl instanceof ConstDecl){
            error("You cannot assign to a constant");
        }
        type = variable.type;
        type.checkType(type, ":=", expression, "Error message plz");
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
