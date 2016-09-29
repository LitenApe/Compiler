package parser;

public class StatmList extends PascalSyntax{

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
