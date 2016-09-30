package parser;

import scanner.*;
import static scanner.TokenKind.*;

public abstract class Statement extends PascalSyntax{

    public Statement(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Statement> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static Statement parse(Scanner s) {
        enterParser("statement");

        Statement st = null;
        switch (s.curToken.kind) {
            case beginToken:
                st = CompoundStatm.parse(s); break;
            case ifToken:
                st = IfStatm.parse(s); break;
            case nameToken:
                switch (s.nextToken.kind) {
                    case assignToken:
                        st = AssignStatm.parse(s); break;
                    case leftBracketToken:
                        st = AssignStatm.parse(s); break;
                        default:
                            st = ProcCallStatm.parse(s); break;
                    }
                break;
            case whileToken:
                st = WhileStatm.parse(s); break;
            default:
                st = EmptyStatm.parse(s); break;
        }

        leaveParser("statement");
        return st;
    }/*End parse*/
}/*End class*/
