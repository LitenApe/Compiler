package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Library extends Block{

    public Library(int n){
        super(n);
    }/*End constructor*/

    public static Library parse(Scanner s){
        return null;
    }/*End parse*/

    @Override
    public String identify() {
        return "<Library> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
