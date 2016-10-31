package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;
import types.*;

public abstract class Factor extends PascalSyntax{

    types.Type type = null;

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
            case nameToken:
                if (s.nextToken.kind == leftBracketToken){
                    factor = Variable.parse(s);
                }
                else if (s.nextToken.kind == leftParToken){
                    factor = FuncCall.parse(s);
                }
                else{
                    //TODO: Kan være funksjon eller UnsignedConstant uansett
                    factor = Variable.parse(s);
                }
                break;
            case notToken:
                factor = Negation.parse(s);
                break;
            case leftParToken:
                factor = InnerExpr.parse(s);
                break;
            default:
                factor = UnsignedConstant.parse(s);
                break;
        }/*End switch*/
        leaveParser("factor");
        return factor;
    }/*End parse*/
}/*End class*/
