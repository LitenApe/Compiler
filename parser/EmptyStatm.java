package parser;

public class EmptyStatm extends Statement{

    public EmptyStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<EmptyStatm> on line " + lineNum;
    } /* End of identify */

} /* End of class */
