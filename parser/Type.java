package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public abstract class Type extends PascalSyntax{

    public Type(int lNum){
        super(lNum);
    }/*End constructor*/

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
