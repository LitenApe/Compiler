package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class ProcDecl extends PascalDecl{

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public static ProcDecl parse(Scanner s){
        enterParser("proc decl");
        leaveParser("proc decl");
        return null;
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
