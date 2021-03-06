package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class UnsignedConstant extends Factor{

    // name | numeric literal | char literal
    public int constVal;
    public String name;

    public UnsignedConstant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){}

    @Override
    public String identify() {
        return "<UnsignedConstant> on line " + lineNum;
    } /* End of identify */

    public static UnsignedConstant parse(Scanner s) {
        enterParser("unsigned constant");

        UnsignedConstant unsignedConstant = null;
        switch(s.curToken.kind){
            case nameToken:
                unsignedConstant = NamedConst.parse(s);
                break;
            case intValToken:
                unsignedConstant = NumberLiteral.parse(s);
                break;
            case charValToken:
                unsignedConstant = CharLiteral.parse(s);
                break;
        }/*End switch*/

        leaveParser("unsigned constant");
        return unsignedConstant;
    }/*End parse*/
}/*End class*/
