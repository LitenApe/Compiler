package parser;

import scanner.*;

public class ProcCallStatm extends Statement{

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<ProcCallStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {

    }

    @Override
    static ProcCallStatm parse(Scanner s) {
        return null; //TODO: Return instance ProcCallStatm
    }

} /* End of class */
