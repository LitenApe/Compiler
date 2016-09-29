package parser;

import scanner.*;

public class AssignStatm extends Statement{

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<AssignStatm> on line " + lineNum;
    } /* End of identify */

    //TODO: prettyPrint? 

    public static AssignStatm parse(Scanner s) {
        return null;
    }/*End parse*/

} /* End of class */
