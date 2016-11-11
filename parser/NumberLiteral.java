package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;
import types.IntType;

public class NumberLiteral extends UnsignedConstant{

    // this right here needs to contain a digit
    public int digit;

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[x] Number Literal");
        f.genInstr("", "movl", "$" + digit + ",%eax", "  '"+digit+"' --- number literal");
    }

    @Override
    public void check(Block curScope, Library lib){
        constVal = digit;
        type = lib.integerType;
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
