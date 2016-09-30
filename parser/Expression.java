package parser;

import scanner.*;

public class Expression extends PascalSyntax{

    public Expression(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<Expression> on line " + lineNum;
    } /* End of identify */

    public static Expression parse(Scanner s) {
        return null;
    }/*End parse*/

}/*End class*/
