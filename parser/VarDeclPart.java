package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class VarDeclPart extends PascalSyntax{

    public VarDeclPart(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<VarDeclPart> on line " + lineNum;
    } /* End of identify */

    public static VarDeclPart parse(Scanner s){
        enterParser("var decl part");
        leaveParser("var decl part");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
