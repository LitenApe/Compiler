package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class ConstDeclPart extends PascalSyntax{

    public ConstDeclPart(int n){
        super(n);
    }/*End constructor*/

    public static ConstDeclPart parse(Scanner s){
        //Added method definition for compilation
        enterParser("const decl part");
        leaveParser("const decl part");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }

    @Override
    public String identify() {
        return "<ConstDeclPart> on line " + lineNum;
    } /* End of identify */

}/*End class*/
