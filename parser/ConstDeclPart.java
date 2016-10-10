package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;
import java.util.ArrayList;

public class ConstDeclPart extends PascalSyntax{

    static ArrayList<ConstDecl> constDeclarations = new ArrayList<>();
    public ConstDeclPart(int n){
        super(n);
    }/*End constructor*/

    public static ConstDeclPart parse(Scanner s){
        enterParser("const decl part");

        System.out.println("Before "+s.curToken.id);
        s.skip(constToken);
        System.out.println("After "+s.curToken.id);
        ConstDeclPart constDeclPart = new ConstDeclPart(s.curLineNum());
        while(s.curToken.kind == nameToken && s.nextToken.kind == equalToken){
            System.out.println("cur: "+s.curToken.id);
            System.out.println("next: "+s.nextToken.id);
            constDeclarations.add(ConstDecl.parse(s));
            s.skip(s.curToken.kind);
        }
        leaveParser("const decl part");
        return constDeclPart;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("const");
        if (!constDeclarations.isEmpty()){
            for (ConstDecl cd : constDeclarations) {
                Main.log.prettyPrintLn(cd.name);
            }
        }
    }/*End prettyprint*/

    @Override
    public String identify() {
        return "<ConstDeclPart> on line " + lineNum;
    } /* End of identify */

}/*End class*/
