package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;

public class WhileStatm extends Statement{
    Expression expr;
    Statement body;

    public WhileStatm(int lNum){
        super(lNum);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<while-statm> on line " + lineNum;
    }

    @Override
    public void prettyPrint() {
        Main.log.prettyPrint("while "); expr.prettyPrint();
        Main.log.prettyPrintLn(" do"); Main.log.prettyIndent();
        body.prettyPrint(); Main.log.prettyOutdent();
    }

    public static WhileStatm parse(Scanner s) {
        enterParser("while-statm");

        WhileStatm ws = new WhileStatm(s.curLineNum());
        s.skip(TokenKind.whileToken);

        ws.expr = Expression.parse(s);
        s.skip(doToken);
        ws.body = Statement.parse(s);

        leaveParser("while-statm");
        return ws;
    }

} /* End of class */
