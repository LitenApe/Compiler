package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class TypeName extends Type{

    public NamedConst namedConstant = null;

    public TypeName(int lNum){
        super(lNum);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){

    }

    @Override
    public void check(Block curScope, Library lib){
        curScope.findDecl(namedConstant.name, this);
        namedConstant.check(curScope, lib);
        type = namedConstant.type;
    }

    @Override
    public void prettyPrint(){
        namedConstant.prettyPrint();
    }/*End prettyPrint*/

    public static TypeName parse(Scanner s) {
        enterParser("type name");

        TypeName typeName = new TypeName(s.curLineNum());
        typeName.namedConstant = NamedConst.parse(s);

        leaveParser("type name");
        return typeName;
    }/*End parse*/

    @Override
    public String identify() {
        return "<type name> on line " + lineNum;
    } /* End of identify */

    public String toString(){
        return namedConstant.name;
    }/*End of toString*/
}/*End class*/
