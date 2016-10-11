package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class CharLiteral extends UnsignedConstant{

    char charValue;
    public CharLiteral(int n){
        super(n);
    }/*End constructor*/

    public static CharLiteral parse(Scanner s) {
        enterParser("char literal");

        s.test(charValToken);
        CharLiteral charLiteral = new CharLiteral(s.curLineNum());

        s.test(charValToken);
        charLiteral.charValue = s.curToken.charVal;
        s.skip(charValToken);

        leaveParser("char literal");
        return charLiteral;
    }/*End parse*/

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
