package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class TypeDecl extends PascalDecl{

    public TypeDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<TypeDecl> " + name + " on line " + lineNum;
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

    public static TypeDecl parse(Scanner s) {
        return null;
    }/*End parse*/
}/*End class*/
