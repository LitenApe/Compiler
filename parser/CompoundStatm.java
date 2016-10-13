package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class CompoundStatm extends Statement{

    // begin : statm list : end
    StatmList stmLst = null;

    public CompoundStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    public static CompoundStatm parse(Scanner s) {
        enterParser("compound statm");
        CompoundStatm cmdStatm = new CompoundStatm(s.curLineNum());

        s.skip(beginToken);

        cmdStatm.stmLst = StatmList.parse(s);

        s.skip(endToken);

        leaveParser("compound statm");
        return cmdStatm;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("begin");
        Main.log.prettyIndent();

        stmLst.prettyPrint();

        Main.log.prettyOutdent();
        Main.log.prettyPrintLn("end;");
    }/*End prettyPrint*/
} /* End of class */
