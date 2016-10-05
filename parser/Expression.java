package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Expression extends PascalSyntax{

    SimpleExpr firstValue;
    SimpleExpr secondValue;
    RelOperator relOperator;

    public Expression(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<Expression> on line " + lineNum;
    } /* End of identify */

    public static Expression parse(Scanner s) {
        enterParser("expression");

        Expression expression = new Expression(s.curLineNum());
        expression.firstValue = SimpleExpr.parse(s);

        // System.out.println("DJFKLSJDJFL: "+s.curToken.kind.toString());
        // System.out.println("DJFKLSJDJFL: "+s.nextToken.kind.toString());
        for (TokenKind kind : RelOperator.operators){
            if(kind == s.curToken.kind){
                System.out.println("Inside: "+s.curToken.kind);
                expression.relOperator = RelOperator.parse(s);
            }
        }
        System.out.println("after: "+s.curToken.id);
        expression.secondValue = SimpleExpr.parse(s);
        // s.skip(s.curToken.kind);
        System.out.println("after second value: "+s.curToken.id);
        leaveParser("expression");
        return expression;
    }/*End parse*/

}/*End class*/
