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
        firstValue.genCode(f);

        if(relOperator != null){
            f.genInstr("","pushl","%eax","");
            secondValue.genCode(f);
            f.genInstr("","popl","%ecx","");
            f.genInstr("","cmpl","%eax,%ecx","");
            f.genInstr("","movl","$0,%eax","");

            //Excessive stuff but it works. I think Dag has done it the way that he uses setl or sete dependant on what token it is
            if (relOperator.opr == lessToken)
                f.genInstr("","setl","%al","Test "+lessToken);
            else if (relOperator.opr == equalToken)
                f.genInstr("","sete","%al","Test "+equalToken);
            else if (relOperator.opr == greaterToken)
                f.genInstr("", "setg", "%al", "Test "+greaterToken);
            else if (relOperator.opr == notEqualToken)
                f.genInstr("", "setne", "%al", "Test "+notEqualToken);
            else
                f.genInstr("","setle","%al","Test "+relOperator.opr.toString());
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
