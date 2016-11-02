package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class ParamDecl extends PascalDecl{

    // name : : : type name

    public NamedConst name = null;
    public TypeName typeName = null;
    public PascalDecl decl = null;

    public ParamDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[x] Param Decl: " + name.name);
        typeName.check(curScope,lib);
        type = typeName.type;

        decl = curScope.findDecl(typeName.toString(), this);
        decl.lineNum = super.lineNum;

        curScope.addDecl(name.toString(),this);
    }

    @Override
    public void prettyPrint(){
        name.prettyPrint();
        Main.log.prettyPrint(": ");
        typeName.prettyPrint();
    }/*End prettyPrint*/

    public static ParamDecl parse(Scanner s){
        enterParser("param decl");

        ParamDecl paramDecl = new ParamDecl(s.curToken.id, s.curLineNum());

        paramDecl.name = NamedConst.parse(s);

        s.skip(colonToken);

        paramDecl.typeName = TypeName.parse(s);

        leaveParser("param decl");
        return paramDecl;
    }

    @Override
    public String identify() {
        return "<param decl> " + name + " on line " + lineNum;
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
