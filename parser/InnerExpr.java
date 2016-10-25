package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

public class InnerExpr extends Factor{

    Expression expression = null;

    public InnerExpr(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){

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
