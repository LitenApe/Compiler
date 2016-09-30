package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

public class FuncDecl extends ProcDecl{

    public FuncDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<FuncDecl> " + name + " on line " + lineNum;
    } /* End of identify */

    public static FuncDecl parse(Scanner s){
        enterParser("func decl");
        leaveParser("func decl");
        return null;
    }/*End parse*/
}/*End class*/
