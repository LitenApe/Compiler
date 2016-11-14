package parser;

import java.util.ArrayList;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public ArrayList<Statement> statmList = new ArrayList<>();

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-x?] Statement List");
        for(Statement s : statmList)
            s.genCode(f);
    }

    @Override
    public void check(Block curScope, Library lib){
        for(Statement ps : statmList){
            ps.check(curScope, lib);
        }
    }

    @Override public String identify() {
        return "<statm list> on line " + lineNum;
    } /* End of identify */

    public static StatmList parse(Scanner s){
        enterParser("statm list");

        StatmList sList = new StatmList(s.curLineNum());

        while(true){
            sList.statmList.add(Statement.parse(s));
            if(s.curToken.kind != semicolonToken){
                break;
            }
            s.skip(semicolonToken);
        }

        leaveParser("statm list");
        return sList;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        for(Statement s : statmList){
            s.prettyPrint();
            if(s != statmList.get(statmList.size() - 1))
                Main.log.prettyPrintLn(";");
        }
        Main.log.prettyPrintLn("");
    }/*End prettyPrint*/
} /* End of class */
