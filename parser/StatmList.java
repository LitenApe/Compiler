package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public ArrayList<PascalSyntax> stmLst = new ArrayList<>();

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> on line " + lineNum;
    } /* End of identify */

    public static StatmList parse(Scanner s){
        enterParser("statm list");

        StatmList stmL = new StatmList(s.curLineNum());

        while(true){

            stmL.stmLst.add(Statement.parse(s));

            if(s.curToken.kind != semicolonToken){
                break;
            }else{
                s.skip(semicolonToken);
            }
        }

        leaveParser("statm list");
        return stmL;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        for(PascalSyntax stLst : stmLst){
            if(stLst != null){
                stLst.prettyPrint();
            }else{
                Main.log.prettyOutdent();
                Main.log.prettyPrintLn("");
                Main.log.prettyIndent();
            }
        }
    }/*End prettyPrint*/
} /* End of class */
