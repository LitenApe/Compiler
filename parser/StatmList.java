package parser;

public class StatmList extends PascalSyntax{

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> on line " + lineNum;
    } /* End of identify */

    public static StatmList parse(Scanner s){
        //Added method definition for compilation
    }/*End parse*/
} /* End of class */
