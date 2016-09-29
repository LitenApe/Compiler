package parser;

public class ParamDecl extends PascalDecl{

    public ParamDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<ParamDecl> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
