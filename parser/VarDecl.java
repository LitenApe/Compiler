package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class VarDecl extends PascalDecl{

    // name : : : type : ;

    public NamedConst namedConstant = null;
    public Type mType = null;
    public types.Type type = null;

    public VarDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        namedConstant.check(curScope,lib);
        mType.check(curScope,lib);
        type = lib.integerType;
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
        return type != null ? "<type decl> " + type.toString() + " in the library": "<VarDecl> " + name + " on line " + lineNum;
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
