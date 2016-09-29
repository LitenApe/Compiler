package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class IfStatm extends Statement{

    public IfStatm(){
        super();
    } /* End of public */

    @Override public String identify() {
        return "<IfStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
