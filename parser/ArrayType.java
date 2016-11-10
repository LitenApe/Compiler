package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class ArrayType extends Type{

    public Constant preConstant = null;
    public Constant postConstant = null;

    public ArrayType(int lNum){
        super(lNum);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[ ] Array Type");
    }

    @Override
    public void check(Block curScope, Library lib){
        preConstant.check(curScope,lib);
        postConstant.check(curScope,lib);
        pType.check(curScope,lib);

        int low = preConstant.constVal;
        int high = postConstant.constVal;
        preConstant.type.checkType(postConstant.type, "array limits", this, "Array error msg");
        type = new types.ArrayType(pType.type,preConstant.type,low,high);
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
