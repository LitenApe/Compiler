package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class Term{

    public Term(){

    } /* End of constructor */

    @Override public String identify() {
        return "<Term> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
