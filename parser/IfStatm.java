package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;

public class IfStatm extends Statement{

    // if : expression : then : statement : [else : statement]
    Expression exp = null;
    Statement stat = null;
    Statement elseExp = null;
    types.Type type = Library.booleanType;

    public IfStatm(int n){
        super(n);
    } /* End of public */

    @Override
    public void genCode(CodeFile f){
        System.out.println("[?] If Statement");

        //TODO: Se over, kan optimaliseres om nødvendig men nå er det gjort slik for å fungere riktig (rekkefølge) i gcd.s
        if (elseExp != null){
            exp.genCode(f);
            String label = f.getLocalLabel();
            // exp.genCode(f);
            f.genInstr("","cmpl","$0,%eax","--- if statm");
            f.genInstr("","je",label,"--- if statm");
            stat.genCode(f);

            String label2 = f.getLocalLabel();
            f.genInstr("","je",label2,"--- if statm");
            f.genInstr(label,"","","--- if statm stuff sdfbsldfhl");
            elseExp.genCode(f);
            f.genInstr(label2,"","","--- if statm secoindsf stuff");
        }
        else{
            exp.genCode(f);
            String label = f.getLocalLabel();
            f.genInstr("","cmpl","$0,%eax","--- if statm");
            f.genInstr("","je",label,"--- if statm");
            stat.genCode(f);
            f.genInstr(label,"","","---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West");
        }

    }

    @Override
    public void check(Block curScope, Library lib){
        exp.check(curScope, lib);

        type.checkType(exp.type ,"if-test" , this, "Expected boolean but found: " + exp.type);

        stat.check(curScope, lib);
        if(elseExp != null){
            elseExp.check(curScope, lib);
        }
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
        return "<if statm> on line " + lineNum;
    } /* End of identify */
} /* End of class */
