package parser;

import scanner.*;

public class IfStatm extends Statement{

    public IfStatm(int n){
        super(n);
    } /* End of public */

    @Override public String identify() {
        return "<IfStatm> on line " + lineNum;
    } /* End of identify */


    @Override
    public void prettyPrint() {

    }

    @Override
    public static IfStatm parse(Scanner s) {
        return null;
    }/*End parse*/

} /* End of class */
