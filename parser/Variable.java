package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class Variable extends Factor{

    NamedConst name = null;
    Expression expression = null;

    public Variable(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){

    }
    
    @Override
    public void prettyPrint(){
        name.prettyPrint();
        if (expression != null){
            Main.log.prettyPrint("[");
            expression.prettyPrint();
            Main.log.prettyPrint("]");
        }
    }/*End prettyPrint*/

    public static Variable parse(Scanner s) {
        enterParser("variable");

        Variable variable = new Variable(s.curLineNum());
        variable.name = NamedConst.parse(s);

        if (s.curToken.kind == leftBracketToken){
            s.skip(leftBracketToken);
            variable.expression = Expression.parse(s);
            s.skip(rightBracketToken);
        }

        //TODO: Kan være variable uten expression (?)
        leaveParser("variable");
        return variable;
    }/*End parse*/

    @Override
    public String identify() {
        return "<Variable> on line " + lineNum;
    } /* End of identify */
}/*End class*/
