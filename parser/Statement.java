package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class Statement{

    public Statement(){

    }/*Enc constructor*/

    @Override public String identify() {
        return "<Statement> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
