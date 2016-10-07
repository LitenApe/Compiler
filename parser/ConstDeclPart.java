package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class ConstDeclPart extends PascalSyntax{

    // ArrayList<ConstDecl> constDeclarations = new ArrayList<>();
    ConstDecl constDecl = null;
    public ConstDeclPart(int n){
        super(n);
    }/*End constructor*/

    public static ConstDeclPart parse(Scanner s){
        enterParser("const decl part");

        s.skip(constToken);
        ConstDeclPart constDeclPart = new ConstDeclPart(s.curLineNum());
        constDeclPart.constDecl = ConstDecl.parse(s);
        // while(s.curToken.kind != semicolonToken){
            // ConstDecl constDecl = ConstDecl.parse(s);
            // constDeclarations.add(constDecl);
        // }
        //TODO: Const Decl Part should have many ConstDecls. What to do here?
        // s.skip(constToken);

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
