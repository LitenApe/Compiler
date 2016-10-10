package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class ProcDecl extends PascalDecl{

    // proc : name : param decl list : ; : block : ;

    public String procName = null;
    public ParamDeclList paramDcl = null;
    public Block blk = null;

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public static ProcDecl parse(Scanner s){
        enterParser("proc decl");

        ProcDecl pDcl = new ProcDecl(s.curToken.id, s.curLineNum());

        s.skip(procedureToken);
        s.test(nameToken);

        pDcl.procName = s.curToken.id;
        s.skip(nameToken);

        if(s.curToken.kind == leftParToken){
            pDcl.paramDcl = ParamDeclList.parse(s);
        }

        s.skip(semicolonToken);
        pDcl.blk = Block.parse(s);

        s.skip(semicolonToken);

        leaveParser("proc decl");
        return pDcl;
    }/*End parse*/

    @Override
    public String identify() {
        return "<ProcDecl> " + name + " on line " + lineNum;
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
