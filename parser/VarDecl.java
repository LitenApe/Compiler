package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class VarDecl extends PascalDecl{

    // name : : : type : ;

    public NamedConst namedConstant = null;
    public Type mType = null;
    public PascalDecl decl = null;

    public VarDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] Var Decl");
        // namedConstant.check(curScope,lib);
        // mType.check(curScope,lib);
        // type = lib.integerType;
        //
        // if(mType.toString().equals("integer")||mType.toString().equals("boolean")||mType.toString().equals("char"))
        //     decl = lib.getDecl(mType.toString());
        // else
        //     decl = this;
        //
        // decl.lineNum = super.lineNum;
        // curScope.addDecl(namedConstant.name, this);
    }

    @Override
    public void prettyPrint(){
        namedConstant.prettyPrint();
        Main.log.prettyPrint(": ");
        mType.prettyPrint();
        Main.log.prettyPrintLn(";");
    }/*End prettyPrint*/

    public static VarDecl parse(Scanner s){
        enterParser("var decl");

        VarDecl varDecl = new VarDecl(s.curToken.id,s.curLineNum());
        varDecl.namedConstant = NamedConst.parse(s);
        s.skip(colonToken);
        varDecl.mType = Type.parse(s);
        s.skip(semicolonToken);

        leaveParser("var decl");
        return varDecl;
    }

    @Override
    public String toString(){
        return namedConstant.toString();
    }

    @Override
    public String identify() {
        System.out.println(decl);
        return "<var decl> " + name + " on line " + lineNum;
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
