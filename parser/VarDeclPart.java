package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class VarDeclPart extends PascalSyntax{

    ArrayList<VarDecl> varDecls = new ArrayList<>();

    public VarDeclPart(int n){
        super(n);
    } /* End of constructor */

    @Override
    public String identify() {
        return "<VarDeclPart> on line " + lineNum;
    } /* End of identify */

    public static VarDeclPart parse(Scanner s){
        enterParser("var decl part");

        VarDeclPart varDeclPart = new VarDeclPart(s.curLineNum());
        s.skip(varToken);

        while(s.curToken.kind == nameToken){
            varDeclPart.varDecls.add(VarDecl.parse(s));
        }/*End while*/

        leaveParser("var decl part");
        return varDeclPart;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
