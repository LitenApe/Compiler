package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class VarDecl extends PascalDecl{

    // name : : : type : ;

    public NamedConst namedConst = null;
    public TypeDecl tpe = null;

    public VarDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public static VarDecl parse(Scanner s){
        enterParser("var decl");

        VarDecl vDcl = new VarDecl(s.curToken.id,s.curLineNum());
        vDcl.namedConst = NamedConst.parse(s);
        s.skip(colonToken);
        vDcl.tpe = TypeDecl.parse(s);
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
