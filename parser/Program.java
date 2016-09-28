public class Program extends PascalDecl{
    Block proBlock;
    Scanner s;

    public Program(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    public parse(Scanner s){
        this.s = s;
    }

    @Override public String identify() {
        return "<program> " + name + " on line " + lineNum;
    }
}/*End class*/
