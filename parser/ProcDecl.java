package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class ProcDecl extends PascalDecl{

    // proc : name : param decl list : ; : block : ;
    public NamedConst procName = null;
    public ParamDeclList paramDecl = null;
    public Block block = null;
    public Block outerScope = null;

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        outerScope = curScope;

        procName.check(block,lib);
        if (paramDecl != null)
            paramDecl.check(block,lib);

        block.check(outerScope,lib);
        curScope.addDecl(name.toString(),this);
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("procedure ");
        procName.prettyPrint();

        if (paramDecl != null){
            paramDecl.prettyPrint();
        }

        Main.log.prettyPrintLn(";");
        block.prettyPrint();
        Main.log.prettyPrint("; {");
        procName.prettyPrint();
        Main.log.prettyPrintLn("}");

    }/*End prettyPrint*/

    public static ProcDecl parse(Scanner s){
        enterParser("proc decl");

        s.skip(procedureToken);
        ProcDecl procDecl = new ProcDecl(s.curToken.id, s.curLineNum());
        procDecl.procName = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            procDecl.paramDecl = ParamDeclList.parse(s);
        }

        s.skip(semicolonToken);
        procDecl.block = Block.parse(s);

        s.skip(semicolonToken);

        leaveParser("proc decl");
        return procDecl;
    }/*End parse*/


    @Override
    public String toString(){
        return procName.toString();
    }

    @Override
    public String identify() {
        return name.equals("write") ? "<proc decl> " + name + " in the library":"<proc decl> " + name + " on line " + lineNum;
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
