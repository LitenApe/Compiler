package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;
import types.CharType;

public class CharLiteral extends UnsignedConstant{

    // ' : [char except] | [' : '] : '

    char charValue;

    public CharLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[x] Char Literal");
        f.genInstr("", "movl", "$" + (int) charValue + ",%eax", "  '"+charValue+"'");
    }

    @Override
    public void check(Block curScope, Library lib){
        constVal = (int) charValue;
        type = lib.characterType;
    }

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
        return "<char literal> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("'"+charValue+"'");
    }/*End prettyPrint*/
}/*End class*/
