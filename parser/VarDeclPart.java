package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.Main;
import types.*;

public class VarDeclPart extends PascalSyntax{

    ArrayList<VarDecl> varDecls = new ArrayList<>();

    public VarDeclPart(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        for(VarDecl v : varDecls){
            v.check(curScope,lib);
            curScope.findDecl(v.mType.toString(), v.decl);
        }
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("var");
        Main.log.prettyIndent();
        for (VarDecl v : varDecls){
            v.prettyPrint();
        }
        Main.log.prettyOutdent();
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<var decl part> on line " + lineNum;
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
} /* End of class */
