package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class ArrayType extends Type{

    public Constant preConstant = null;
    public Constant postConstant = null;
    public Type type = null;

    public ArrayType(int lNum){
        super(lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){

    }
    
    public static ArrayType parse(Scanner s) {
        enterParser("array-type");

        ArrayType arrType = new ArrayType(s.curLineNum());

        s.skip(arrayToken);
        s.skip(leftBracketToken);

        arrType.preConstant = Constant.parse(s);

        s.skip(rangeToken);

        arrType.postConstant = Constant.parse(s);

        s.skip(rightBracketToken);
        s.skip(ofToken);

        arrType.type = Type.parse(s);

        leaveParser("array-type");
        return arrType;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("array [");

        preConstant.prettyPrint();

        Main.log.prettyPrint("..");

        postConstant.prettyPrint();

        Main.log.prettyPrint("] of ");

        type.prettyPrint();

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<array type> on line " + lineNum;
    } /* End of identify */
}/*End class*/
