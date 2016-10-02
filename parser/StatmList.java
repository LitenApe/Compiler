package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public ArrayList<Statement> stmLst = new ArrayList<>();

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

            Statement statm = new Statement(s.curLineNum());
            statm.parse(s);
            stmL.stmLst.add(statm);

            if(s.curToken.kind != semicolonToken){
                break;
            }
        }

        leaveParser("statm list");
        return stmL;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
