package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;
import types.IntType;

public class NumberLiteral extends UnsignedConstant{

    public int digit;
    public IntType type = null; 

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        type = lib.integerType;
        super.type = this.type;
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(""+digit);
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<NumberLiteral> on line " + lineNum;
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
