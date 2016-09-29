package parser;

import scanner.*;

public class EmptyStatm extends Statement{

    public EmptyStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<EmptyStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public static EmptyStatm parse(Scanner s) {
        return null;
    }/*End parse*/
} /* End of class */
