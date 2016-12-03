package parser;

import main.*;
import scanner.Scanner;
import static scanner.TokenKind.*;

public class InnerExpr extends Factor{

    Expression expression = null;
    PascalDecl decl = null;

    public InnerExpr(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        expression.genCode(f);
    }

    @Override
    public void check(Block curScope, Library lib){
        if (expression != null){
            expression.check(curScope,lib);
            type = expression.type;
        }
    }

    public static InnerExpr parse(Scanner s) {
        enterParser("inner expr");

        s.skip(leftParToken);
        InnerExpr innerExpr = new InnerExpr(s.curLineNum());
        innerExpr.expression = Expression.parse(s);
        s.skip(rightParToken);

        leaveParser("inner expr");
        return innerExpr;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("(");

        expression.prettyPrint();

        Main.log.prettyPrint(")");
    }/*End prettyPrint*/


}/*End class*/
