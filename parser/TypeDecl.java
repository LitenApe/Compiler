package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class TypeDecl extends PascalDecl{

    public TypeDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<TypeDecl> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
