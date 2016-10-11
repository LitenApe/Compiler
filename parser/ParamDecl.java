package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class ParamDecl extends PascalDecl{

    // name : : : type name

    public NamedConst name = null;
    public String tName = null;

    public ParamDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public static ParamDecl parse(Scanner s){
        enterParser("param decl");

        ParamDecl parDecl = new ParamDecl(s.curToken.id, s.curLineNum());

        parDecl.name = NamedConst.parse(s);

        s.skip(colonToken);

        s.test(nameToken);
        parDecl.tName = s.curToken.id;
        s.skip(nameToken);

        leaveParser("param decl");
        return parDecl;
    }

    @Override
    public String identify() {
        return "<ParamDecl> " + name + " on line " + lineNum;
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

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
