package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class EmptyStatm extends Statement{

    public EmptyStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<EmptyStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
