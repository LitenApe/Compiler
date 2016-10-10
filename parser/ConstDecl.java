package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class ConstDecl extends PascalDecl{

    // name : = : constant : ;
    public NamedConst namedConstant= null;
    public Constant cnst = null;

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public static ConstDecl parse(Scanner s){
        enterParser("const decl");

        ConstDecl constD = new ConstDecl(s.curToken.id,s.curLineNum());

        constD.namedConstant = NamedConst.parse(s); //TODO: TS, det her er named constant for navn.

        s.skip(equalToken);
        constD.cnst = Constant.parse(s);

        s.skip(semicolonToken);

        leaveParser("const decl");
        return constD;
    }

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
}/*End class*/
