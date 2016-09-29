package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class VarDeclPart{

    public VarDeclPart(){

    } /* End of constructor */

    @Override public String identify() {
        return "<VarDeclPart> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
