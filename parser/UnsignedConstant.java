package parser;

import scanner.*;
import static scanner.TokenKind.*;

public abstract class UnsignedConstant extends Factor{

    public UnsignedConstant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify() {
        return "<UnsignedConstant> on line " + lineNum;
    } /* End of identify */

    public static UnsignedConstant parse(Scanner s) {
        return null;
    }/*End parse*/

    //TODO: prettyPrint?
    
}/*End class*/
