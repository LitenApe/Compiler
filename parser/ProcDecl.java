package parser;

public class ProcDecl extends PascalDecl{

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<ProcDecl> " + name + " on line " + lineNum;
    } /* End of identify */

    public static ProcDecl parse(Scanner s){
        //Added method definition for compilation
    }/*End parse*/
}/*End class*/
