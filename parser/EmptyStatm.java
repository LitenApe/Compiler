package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class EmptyStatm extends Statement{

    public EmptyStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<EmptyStatm> on line " + lineNum;
    } /* End of identify */

    public static EmptyStatm parse(Scanner s) {
        enterParser("empty statm");
        leaveParser("empty statm");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        System.out.println("Empty Statment");
    }/*End prettyPrint*/
} /* End of class */
