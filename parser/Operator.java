package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class Operator extends PascalSyntax{

    public types.Type type = null;

    public Operator(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){}

    @Override
    public String identify() {
        return "<operator> on line " + lineNum;
    } /* End of identify */

    public static Operator parse(Scanner s) {
        enterParser("operator");
        leaveParser("operator");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("Operator");
    }/*End prettyPrint*/

}/*End class*/
