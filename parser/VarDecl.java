package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class VarDecl extends PascalDecl{

    // name : : : type : ;

    public NamedConst namedConst = null;
    public Type tpe = null;

    public VarDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void prettyPrint(){
        namedConst.prettyPrint();
        Main.log.prettyPrint(": ");
        tpe.prettyPrint();
        Main.log.prettyPrintLn(";");
    }/*End prettyPrint*/

    public static VarDecl parse(Scanner s){
        enterParser("var decl");

        VarDecl vDcl = new VarDecl(s.curToken.id,s.curLineNum());
        vDcl.namedConst = NamedConst.parse(s);
        s.skip(colonToken);
        vDcl.tpe = Type.parse(s);
        s.skip(semicolonToken);

        leaveParser("var decl");
        return vDcl;
    }

    @Override
    public String identify() {
        return "<VarDecl> " + name + " on line " + lineNum;
    } /* End of identify */

    @Override
    public void checkWhetherAssignable(PascalSyntax where){

    }/*End checkWhetherAssignable*/

    @Override
    public void checkWhetherFunction(PascalSyntax where){

    }/*End checkWhetherFunction*/

    @Override
    public void checkWhetherProcedure(PascalSyntax where){

    }/*End checkWhetherProcedure*/

    @Override
    public void checkWhetherValue(PascalSyntax where){

    }/*End checkWhetherValue*/
}/*End class*/
