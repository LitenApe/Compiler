package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class TypeName extends Type{

    public NamedConst namedConstant = null;
    public types.Type type = null;

    public TypeName(int lNum){
        super(lNum);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        switch(namedConstant.name){
            case "integer":
                type = lib.integerType;
                break;
            case "boolean":
                type = lib.booleanType;
                break;
            case "char":
                type = lib.characterType;
                break;
            default:
                break;
        }

        namedConstant.check(curScope, lib);
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
        return "<type decl> on line " + lineNum;
    } /* End of identify */
}/*End class*/
