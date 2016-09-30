package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class ConstDeclPart extends PascalSyntax{

    ConstDecl constDecl;
    public ConstDeclPart(int n){
        super(n);
    }/*End constructor*/

    public static ConstDeclPart parse(Scanner s){
        enterParser("const decl part");

        ConstDeclPart constDeclPart = new ConstDeclPart(s.curLineNum());
        s.skip(constToken);
        constDeclPart.constDecl = ConstDecl.parse(s);

        leaveParser("const decl part");
        return constDeclPart;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }

    @Override
    public String identify() {
        return "<ConstDeclPart> on line " + lineNum;
    } /* End of identify */

}/*End class*/
