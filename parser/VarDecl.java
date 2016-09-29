public class VarDecl extends PascalDecl{

    public VarDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<VarDecl> " + name + " on line " + lineNum;
    } /* End of identify */
    
}/*End class*/
