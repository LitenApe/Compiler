package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class ConstDecl extends PascalDecl{

    // name : = : constant : ;
    
    public NamedConst namedConstant= null;
    public Constant constant = null;
    public types.Type type = null;

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[x] Constant Decleration: " + namedConstant.name);

        namedConstant.check(curScope,lib);
        constant.check(curScope,lib);

        type = constant.type;

        curScope.addDecl(namedConstant.toString(),this);
    }
    @Override
    public void prettyPrint(){
        namedConstant.prettyPrint();
        Main.log.prettyPrint(" = ");
        constant.prettyPrint();
        Main.log.prettyPrintLn(";");
    }/*End prettyPrint*/

    public static ConstDecl parse(Scanner s){
        enterParser("const decl");

        ConstDecl constDecl = new ConstDecl(s.curToken.id,s.curLineNum());

        constDecl.namedConstant = NamedConst.parse(s);

        s.skip(equalToken);
        constDecl.constant = Constant.parse(s);

        s.skip(semicolonToken);

        leaveParser("const decl");
        return constDecl;
    }

    @Override
    public String toString(){
        return namedConstant.toString();
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
}/*End class*/
