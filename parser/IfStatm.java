package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class IfStatm extends Statement{

    // if : expression : then : statement : else : statement
    Expression exp = null;
    Statement stat = null;
    Statement elseExp = null;

    public IfStatm(int n){
        super(n);
    } /* End of public */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("if statm");
        // try{
            // exp.check(curScope, lib);
        // }catch(Exception err){
            // System.out.println("Error: " + exp + " in if statm");
        // }
        // stat.check(curScope, lib);
        // if(elseExp != null)
        //     elseExp.check(curScope, lib);
    }

    @Override
    public void prettyPrint() {
        Main.log.prettyPrint("if ");
        exp.prettyPrint();
        Main.log.prettyPrintLn(" then");
        Main.log.prettyIndent();
        stat.prettyPrint();
        Main.log.prettyOutdent();

        if (elseExp != null){
            Main.log.prettyPrintLn("");
            Main.log.prettyPrintLn("else");
            Main.log.prettyIndent();
            elseExp.prettyPrint();
            Main.log.prettyOutdent();
        }
    }/*End prettyprint*/

    public static IfStatm parse(Scanner s) {
        enterParser("if-statm");

        IfStatm ifStat = new IfStatm(s.curLineNum());

        s.skip(ifToken);
        ifStat.exp = Expression.parse(s);
        s.skip(thenToken);

        ifStat.stat = Statement.parse(s);

        if(s.curToken.kind == elseToken){
            s.skip(elseToken);
            ifStat.elseExp = Statement.parse(s);
        }

        leaveParser("if-statm");
        return ifStat;
    }/*End parse*/

    @Override public String identify() {
        return "<IfStatm> on line " + lineNum;
    } /* End of identify */
} /* End of class */
