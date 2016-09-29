package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class StatmList{

    public StatmList(){

    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
