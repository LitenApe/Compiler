package parser;

import scanner.*;
import types.Type;
import main.Main;
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
    public void check(Block curScope, Library lib){
        System.out.println("[-] Expression");
        firstValue.check(curScope,lib);
        // type = firstValue.type;
        // if (relOperator != null){
        //     relOperator.check(curScope, lib);
        //     secondValue.check(curScope,lib);
        //     String oprName = relOperator.opr.toString();
        //     try{
        //         type.checkType(secondValue.type,oprName+" operands",this,"Operands to "+oprName+" are of different type!");
        //     }catch(Exception err){
        //         System.out.println(type);
        //     }
        //     type = lib.booleanType;
        //     Main.log.noteTypeCheck(type, firstValue.toString(), secondValue.type, this);
        // }
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
        return "<Expression> on line " + lineNum;
    } /* End of identify */
}/*End class*/
