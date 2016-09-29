package parser;

public class Term extends PascalSyntax{

    public Term(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<Term> on line " + lineNum;
    } /* End of identify */

} /* End of class */
