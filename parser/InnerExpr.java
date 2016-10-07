package parser;
import scanner.Scanner;
import static scanner.TokenKind.*; 

public class InnerExpr extends Factor{

    Expression expr = null;

    public InnerExpr(int n){
        super(n);
    }/*End constructor*/

    public static InnerExpr parse(Scanner s) {
        enterParser("inner expr");

        s.skip(leftParToken);
        InnerExpr innerExpr = new InnerExpr(s.curLineNum());
        innerExpr.expr = Expression.parse(s);
        s.skip(rightParToken);

        leaveParser("inner expr");
        return innerExpr;
    }/*End parse*/
    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/


}/*End class*/
