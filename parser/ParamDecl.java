package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class ParamDecl extends PascalDecl{

    // name : : : type name

    public NamedConst name = null;
    public TypeName tName = null;

    public ParamDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void prettyPrint(){
        name.prettyPrint();
        Main.log.prettyPrint(": ");
        tName.prettyPrint();
    }/*End prettyPrint*/

    public static ParamDecl parse(Scanner s){
        enterParser("param decl");

        ParamDecl parDecl = new ParamDecl(s.curToken.id, s.curLineNum());

        parDecl.name = NamedConst.parse(s);

        s.skip(colonToken);

        parDecl.tName = TypeName.parse(s);

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
}/*End class*/
