package parser;

import scanner.*;
import types.Type;
import main.*;
import static scanner.TokenKind.*;

public class Expression extends PascalSyntax{

    SimpleExpr firstValue = null;
    RelOperator relOperator = null;
    SimpleExpr secondValue = null;
    types.Type type = null;

    public Expression(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-] Expression");

        firstValue.genCode(f);

        if(relOperator != null){
            relOperator.genCode(f);
            secondValue.genCode(f);
        }
    }

    @Override
    public void check(Block curScope, Library lib){
        firstValue.check(curScope,lib);
        type = firstValue.type;

        if (relOperator != null){
            relOperator.check(curScope, lib);
            secondValue.check(curScope,lib);
            String oprName = relOperator.opr.toString();
            type.checkType(secondValue.type,oprName+" operands",this,"Operands to "+oprName+" are of different type!");
            type = lib.booleanType;
        }
    }

    public static Expression parse(Scanner s) {
        enterParser("expression");
        Expression expression = new Expression(s.curLineNum());
        expression.firstValue = SimpleExpr.parse(s);

        if(s.curToken.kind.isRelOpr()){
            expression.relOperator = RelOperator.parse(s);
            expression.secondValue = SimpleExpr.parse(s);
        }

        leaveParser("expression");
        return expression;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        firstValue.prettyPrint();
        if(relOperator != null){
            relOperator.prettyPrint();
            secondValue.prettyPrint();
        }
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<expression> on line " + lineNum;
    } /* End of identify */
}/*End class*/
