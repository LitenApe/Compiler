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

        StatmList statmList = new StatmList(s.curLineNum());

        while(true){

            statmList.statmList.add(Statement.parse(s));

            if(s.curToken.kind != semicolonToken){
                break;
            }else{
                s.skip(semicolonToken);
            }
        }

        leaveParser("statm list");
        return statmList;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        System.out.println(statmList.size());
        for(PascalSyntax s : statmList){
            System.out.println("StatmList: " + s.identify());
            s.prettyPrint();
        }
    }/*End prettyPrint*/
} /* End of class */
