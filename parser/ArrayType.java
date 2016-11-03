package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class ArrayType extends Type{

    public Constant preConstant = null;
    public Constant postConstant = null;
    public Type pType = null;

    public ArrayType(int lNum){
        super(lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] ArrayType");
        preConstant.check(curScope,lib);
        postConstant.check(curScope,lib);
        pType.check(curScope,lib);
        if (preConstant.uConstant instanceof NumberLiteral && postConstant.uConstant instanceof NumberLiteral) {
            NumberLiteral pre = (NumberLiteral) preConstant.uConstant;
            NumberLiteral post = (NumberLiteral) postConstant.uConstant;
            int low = pre.digit;
            int high = post.digit;
            type = new types.ArrayType(pType.type,lib.integerType,low,high);
        }
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

        arrType.pType = Type.parse(s);

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

        pType.prettyPrint();

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<array type> on line " + lineNum;
    } /* End of identify */
}/*End class*/
