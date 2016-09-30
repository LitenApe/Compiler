package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Constant extends PascalSyntax{

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify(){
        return "<constant> on line " + lineNum;
    }/*End identify*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static Constant parse(Scanner s){
        enterParser("constant");
        leaveParser("constant");
        return null;
    }
}/*End class*/
