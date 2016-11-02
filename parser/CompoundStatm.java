package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class CompoundStatm extends Statement{

    // begin : statm list : end
    StatmList statmList = null;

    public CompoundStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] Compound Statment");
    }

    @Override
    public String identify() {
        return "<compound statm> on line " + lineNum;
    } /* End of identify */

    public static CompoundStatm parse(Scanner s) {
        enterParser("compound statm");
        CompoundStatm compoundStatm = new CompoundStatm(s.curLineNum());

        s.skip(beginToken);

        compoundStatm.statmList = StatmList.parse(s);

        s.skip(endToken);

        leaveParser("compound statm");
        return compoundStatm;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("begin");
        Main.log.prettyIndent();

        statmList.prettyPrint();

        Main.log.prettyOutdent();
        Main.log.prettyPrint("end");
    }/*End prettyPrint*/
} /* End of class */
