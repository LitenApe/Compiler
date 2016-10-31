package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class Operator extends PascalSyntax{

    public Operator(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Operator> on line " + lineNum;
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
