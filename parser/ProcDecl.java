public class ProcDecl extends PascalDecl{

    public ProcDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<ProcDecl> " + name + " on line " + lineNum;
    } /* End of identify */
}/*End class*/
