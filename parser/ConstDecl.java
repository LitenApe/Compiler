package parser;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class ConstDecl extends PascalDecl{

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<ConstDecl> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
