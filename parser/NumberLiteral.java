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

        s.test(intValToken);

        numberLiteral.digit = s.curToken.intVal;

        System.out.println("NL: -s: " + s.curToken.identify());

        s.skip(intValToken);

        System.out.println("NL: -c: " + s.curToken.identify());
        System.out.println("NL: -n: " + s.nextToken.identify());

        leaveParser("number literal");
        return numberLiteral;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
