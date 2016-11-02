package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;
import types.BoolType;

public class Negation extends Factor{

    Factor factor = null;

    public Negation(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<negation> on line " + lineNum;
    } /* End of identify */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] Negation");
        super.type = lib.booleanType;
    }

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
        Main.log.prettyPrint("not ");
        factor.prettyPrint();
    }/*End prettyPrint*/
}/*End class*/
