package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class Negation extends Factor{

    Factor factor = null;
    public Negation(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Negation> on line " + lineNum;
    } /* End of identify */

    public static Negation parse(Scanner s) {
        enterParser("negation");

        s.skip(notToken);
        Negation negation = new Negation(s.curLineNum());
        negation.factor = Factor.parse(s);

        leaveParser("negation");
        return negation;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("Negation");
    }/*End prettyPrint*/
}/*End class*/
