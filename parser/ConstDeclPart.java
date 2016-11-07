package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;
import java.util.ArrayList;

public class ConstDeclPart extends PascalSyntax{

    // const : const decl

    ArrayList<ConstDecl> constDeclarations = new ArrayList<>();
    types.Type type = null;

    public ConstDeclPart(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        for(ConstDecl p : constDeclarations){
            p.check(curScope,lib);
            type = p.type;
        }
    }

    public static ConstDeclPart parse(Scanner s){
        enterParser("const decl part");
        s.skip(constToken);

        ConstDeclPart constDeclPart = new ConstDeclPart(s.curLineNum());

        while(s.curToken.kind == nameToken){
            constDeclPart.constDeclarations.add(ConstDecl.parse(s));
        }

        leaveParser("const decl part");
        return constDeclPart;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("const");
        Main.log.prettyIndent();
        if (!constDeclarations.isEmpty()){
            for (ConstDecl cd : constDeclarations) {
                cd.prettyPrint();
            }
        }
        Main.log.prettyOutdent();
    }/* End prettyprint */

    @Override
    public String identify(){
        return "<const decl part> on line " + lineNum;
    } /* End of identify */

}/*End class*/
