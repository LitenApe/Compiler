package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class ArrayType extends TypeDecl{


    public ArrayType(String id, int lNum){
        super(id,lNum);
    }/*Enc constructor*/

    public static ArrayType parse(Scanner s) {
        enterParser("array type");
        leaveParser("array type");
        return null;
    }/*End parse*/
}/*End class*/
