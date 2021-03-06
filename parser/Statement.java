package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;

public abstract class Statement extends PascalSyntax{

    types.Type type = null;

    public Statement(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){}

    @Override
    public String identify() {
        return "<Statement> on line " + lineNum;
    } /* End of identify */
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
