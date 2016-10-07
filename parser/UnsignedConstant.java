package parser;

import scanner.*;
import static scanner.TokenKind.*;

public abstract class UnsignedConstant extends Factor{

    String name = "";

    public UnsignedConstant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<UnsignedConstant> on line " + lineNum;
    } /* End of identify */

    public static UnsignedConstant parse(Scanner s) {
        enterParser("unsigned constant");

        UnsignedConstant unsignedConstant = null;
        
        switch(s.curToken.kind){
            case nameToken:
                unsignedConstant =

        }/*End switch*/

        leaveParser("unsigned constant");
        return null;
    }/*End parse*/

    //TODO: prettyPrint?

}/*End class*/
