package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class PascalDecl extends PascalSyntax {
    String name, progProcFuncName;
    int declLevel = 1, declOffset = 0;
    types.Type type = null;

    PascalDecl(String id, int lNum) {
    	super(lNum);
    	name = id;
    }

    @Override
    public void genCode(CodeFile f){}

    @Override
    public void prettyPrint(){}

    @Override
    public String identify() {
        return "<PascalDecl> on line " + lineNum;
    } /* End of identify */

    public static PascalDecl parse(Scanner s) {
        return null;
    }/*End parse*/

    @Override
    public void check(Block curScope, Library lib){}

    abstract void checkWhetherAssignable(PascalSyntax where);
    abstract void checkWhetherFunction(PascalSyntax where);
    abstract void checkWhetherProcedure(PascalSyntax where);
    abstract void checkWhetherValue(PascalSyntax where);
}
