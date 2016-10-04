package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class Factor extends PascalSyntax{
    UnsignedConstant uConstant = null;
    // Variable variable = null;
    // FuncCall funcCall = null;
    InnerExpr innerExpression = null;
    Negation negation = null;

    public Factor(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Factor> on line " + lineNum;
    } /* End of identify */

    public static Factor parse(Scanner s) {
        enterParser("factor");

        Factor factor = null;
        switch(s.curToken.kind){
            case leftBracketToken: //Variables, rm l8r
                factor = Variable.parse(s);
                break;
            case leftParToken: //Func call
                factor = FuncCall.parse(s);
                break;
            default:
                factor = Variable.parse(s);
        }/*End switch*/

        leaveParser("factor");
        return factor;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

}/*End class*/
