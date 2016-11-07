package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public abstract class Type extends PascalSyntax{

    // type name | array type

    public types.Type type = null;
    public Type pType = null;

    public Type(int lNum){
        super(lNum);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){

    }

    public static Type parse(Scanner s) {
        enterParser("type");

        Type type = null;
        if (s.curToken.kind == nameToken){
            type = TypeName.parse(s); //error er ikke superklasse
        }else{
            type = ArrayType.parse(s);
        }

        leaveParser("type");
        return type;
    }/*End parse*/

    @Override
    public String identify() {
        return "<type> on line " + lineNum;
    } /* End of identify */
} /*End class*/
