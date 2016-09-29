package parser;

import scanner.*;

public class CharLiteral extends UnsignedConstant{

    public CharLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static CharLiteral parse(Scanner s) {
        return null;
    }/*End parse*/

}/*End class*/
