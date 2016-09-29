package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public ProcCallStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<ProcCallStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
