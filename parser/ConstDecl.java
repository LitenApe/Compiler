package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class ConstDecl extends PascalDecl{

    public String name = "";
    public Constant cnst = null;

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<ConstDecl> " + name + " on line " + lineNum;
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

    public static ConstDecl parse(Scanner s){
        enterParser("const decl");

        s.test(nameToken);
        ConstDecl constD = new ConstDecl(s.curToken.id,s.curLineNum());
        constD.name = s.curToken.id;
        s.skip(nameToken);
        constD.cnst = Constant.parse(s);

        // not done!

        leaveParser("const decl");
        return constD;
    }
}/*End class*/
