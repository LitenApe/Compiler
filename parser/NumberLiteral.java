package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class NumberLiteral extends UnsignedConstant{

    int digit;

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<NumberLiteral> on line " + lineNum;
    } /* End of identify */

    public static NumberLiteral parse(Scanner s) {
        enterParser("number literal");

        NumberLiteral numberLiteral = new NumberLiteral(s.curLineNum());

        // s.test(intValToken);
        numberLiteral.digit = s.curToken.intVal;
<<<<<<< HEAD

        s.skip(intValToken);
=======
        // s.skip(intValToken); //TODO: If uncommented this is an issue. to do this.
>>>>>>> 7e06c4b49b9e2680401cc27300dfa6343d2af58f

        leaveParser("number literal");
        return numberLiteral;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
