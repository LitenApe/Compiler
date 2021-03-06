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
    public void genCode(CodeFile f){
        String testLabel = f.getLocalLabel(),
        endLabel = f.getLocalLabel();
        f.genInstr(testLabel, "", "", "Start while-statement");
        expr.genCode(f);
        f.genInstr("", "cmpl", "$0,%eax", "");
        f.genInstr("", "je", endLabel, "");
        body.genCode(f);
        f.genInstr("", "jmp", testLabel, "");
        f.genInstr(endLabel, "", "", "End while-statement");
    }

    @Override
    public void check(Block curScope, Library lib){
        expr.check(curScope, lib);
        expr.type.checkType(lib.booleanType, "while-test", this,
        "While-test is not Boolean.");
        body.check(curScope, lib);
    }

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
        s.skip(whileToken);

        ws.expr = Expression.parse(s);
        s.skip(doToken);
        ws.body = Statement.parse(s);

        leaveParser("while-statm");
        return ws;
    }

} /* End of class */
