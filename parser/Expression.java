package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Expression extends PascalSyntax{

    SimpleExpr firstValue = null;
    SimpleExpr secondValue = null;
    RelOperator relOperator = null;

    public Expression(int n){
        super(n);
    }/*End constructor*/

    public static Expression parse(Scanner s) {
        enterParser("expression");

        Expression expression = new Expression(s.curLineNum());
        expression.firstValue = SimpleExpr.parse(s);

        for (TokenKind kind : RelOperator.operators){
            if(kind == s.curToken.kind){
                expression.relOperator = RelOperator.parse(s);
                expression.secondValue = SimpleExpr.parse(s);
            }
        }
        leaveParser("expression");
        return expression;
    }/*End parse*/
    
    @Override
    public void prettyPrint(){
        if(firstValue != null){
            firstValue.prettyPrint();
        }
        if(relOperator != null){
            relOperator.prettyPrint();
        }
        if(secondValue != null){
            secondValue.prettyPrint();
        }
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<Expression> on line " + lineNum;
    } /* End of identify */
}/*End class*/
