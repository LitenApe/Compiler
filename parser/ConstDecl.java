package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;

public class ConstDecl extends PascalDecl{

    // name : = : constant : ;

    public NamedConst namedConstant= null;
    public Constant constant = null;
    public int constVal;

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public ConstDecl(String id, int lNum, Library lib){
        super(id, lNum);
        type = lib.booleanType;
    }

    @Override
    public void genCode(CodeFile f){
        constant.genCode(f);
    }

    @Override
    public void check(Block curScope, Library lib){
        namedConstant.check(curScope,lib);
        curScope.addDecl(namedConstant.toString(), this);
        constant.check(curScope,lib);
        declLevel = curScope.declLevel;

        constVal = constant.constVal; //NOTE: Added in part 4

        if(name.equals("true") || name.equals("false"))
            type = lib.booleanType;
        else
            type = constant.type;
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
    public String identify() {
        return lineNum == 0 ? "<const decl> " + name + " in the library" : "<const decl> " + name + " on line " + lineNum;
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
