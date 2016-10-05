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

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    //TODO: this class doesnt override any of the 4 abstract methods in ProcDecl
    //which is inherited from PascalDecl. If needed, we need to implement this
    //later
}/*End class*/
