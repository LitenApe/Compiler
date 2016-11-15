package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class ProcDecl extends PascalDecl{

    // proc : name : param decl list : ; : block : ;
    public NamedConst procName = null;
    public ParamDeclList paramDecl = null;
    public Block block = null;
    public String label = null;

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-x?] Procedure Decleration");

        if(paramDecl != null){
            for (ParamDecl p : paramDecl.listOfParamDecls)
                p.declLevel = this.declLevel;
            block.declLevel = this.declLevel;
        }

        int numBytes = paramDecl != null ? 32+paramDecl.listOfParamDecls.size()*4 : 32;
        label = f.getLabel(procName.name);
        f.genInstr("proc$"+label,"","","");
        f.genInstr("","enter","$"+numBytes+",$"+declLevel,"");
        block.genCode(f);
        f.genInstr("","leave","","--- proc call");
        f.genInstr("","ret","","--- proc call");
    }

    @Override
    public void check(Block curScope, Library lib){
        procName.check(curScope,lib);
        curScope.addDecl(procName.name, this);
        declLevel++;

        if (paramDecl != null)
            paramDecl.check(block, lib);

        block.check(curScope, lib);
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
