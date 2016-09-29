package parser;

public class FuncDecl extends ProcDecl{

    public FuncDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<FuncDecl> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
