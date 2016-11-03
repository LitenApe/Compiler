package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;
import types.IntType;

public class NumberLiteral extends UnsignedConstant{

    // this right here needs to contain a digit

    public int digit;

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[x] Number literal: " + digit);
        super.type = lib.integerType;
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(""+digit);
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<number literal> on line " + lineNum;
    } /* End of identify */

    public static NumberLiteral parse(Scanner s) {
        enterParser("number literal");

        NumberLiteral numberLiteral = new NumberLiteral(s.curLineNum());

        s.test(intValToken);
        numberLiteral.digit = s.curToken.intVal;
        s.skip(intValToken);

        leaveParser("number literal");
        return numberLiteral;
    }/*End parse*/
}/*End class*/
