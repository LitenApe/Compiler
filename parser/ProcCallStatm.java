package parser;

import scanner.*;
import static scanner.TokenKind.*;

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

    public static ProcCallStatm parse(Scanner s) {
        enterParser("proc call statm");
        leaveParser("proc call statm");
        return null; //TODO: Return instance ProcCallStatm
    }

} /* End of class */
