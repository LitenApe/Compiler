package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Variable extends Factor{

    NamedConst name = null;
    Expression expression = null;

    public Variable(int n){
        super(n);
    }/*End constructor*/

    public static Variable parse(Scanner s) {
        enterParser("variable");

        Variable variable = new Variable(s.curLineNum());
        variable.name = NamedConst.parse(s);

        if (s.curToken.kind == leftBracketToken){
            s.skip(leftBracketToken);
            variable.expression = Expression.parse(s);
            s.skip(rightBracketToken);
        }

        leaveParser("variable");
        return variable;
    }/*End parse*/

    @Override
    public String identify() {
        return "<Variable> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
