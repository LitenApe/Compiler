package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class EmptyStatm extends Statement{

    // it's name is empty statm..... which means it's empty
    // why do you even look

    public EmptyStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){}

    @Override
    public String identify() {
        return "<EmptyStatm> on line " + lineNum;
    } /* End of identify */

    public static EmptyStatm parse(Scanner s) {
        enterParser("empty statm");

        EmptyStatm emptyStatm = new EmptyStatm(s.curLineNum());

        leaveParser("empty statm");
        return emptyStatm;
    }/*End parse*/

    @Override
    public void prettyPrint(){
    }/*End prettyPrint*/
} /* End of class */
