package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public ArrayList<Statement> statmList = new ArrayList<>();

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> on line " + lineNum;
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
        // System.out.println(statmList.size());
            // System.out.println("StatmList: " + s.identify());
        for(Statement s : statmList){
            // System.out.println(statmList.size());
            s.prettyPrint();
            if(s != statmList.get(statmList.size() - 1))
                Main.log.prettyPrintLn(";");
        }
    }/*End prettyPrint*/
} /* End of class */
