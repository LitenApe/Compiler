public class Program extends PascalDecl{
    Block proBlock;

    public Program(String id, int lNum){
        super(String id, int lNum);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<program> " + name + " on line " + lineNum;
    }
}/*End class*/
