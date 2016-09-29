package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class CompoundStatm extends Statement{

    public CompoundStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<CompoundStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
