package parser;

public class ConstDecl extends PascalDecl{

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<ConstDecl> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
