package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public ArrayList<PascalSyntax> statmList = new ArrayList<>();

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
            sList.statmList.get(sList.statmList.size() - 1).prettyPrint();
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
        for(PascalSyntax s : statmList){
            // System.out.println("StatmList: " + s.identify());
            s.prettyPrint();
        }
    }/*End prettyPrint*/
} /* End of class */
