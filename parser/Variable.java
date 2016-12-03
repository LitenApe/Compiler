package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;

public class Variable extends Factor{

    NamedConst name = null;
    Expression expression = null;
    PascalDecl decl = null;

    public Variable(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        decl.genCode(f);
        if(expression != null)
            expression.genCode(f);
    }

    @Override
    public void check(Block curScope, Library lib){
        name.check(curScope,lib);

        decl = curScope.findDecl(name.name, this);

        if (expression != null)
            expression.check(curScope,lib);

        type = decl.type;

        if(expression != null)
            lib.integerType.checkType(expression.type, "array index", this, type.toString() + " vs " + expression.type.toString());
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
        return "<variable> on line " + lineNum;
    } /* End of identify */
}/*End class*/
