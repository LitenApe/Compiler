package parser;

import scanner.*;

public abstract class Statement extends PascalSyntax{

    public Statement(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<Statement> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static Statement parse(Scanner s) {
        return null;
    }/*End parse*/
}/*End class*/
