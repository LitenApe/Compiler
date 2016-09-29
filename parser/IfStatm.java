package parser;

public class IfStatm extends Statement{

    public IfStatm(int n){
        super(n);
    } /* End of public */

    @Override public String identify() {
        return "<IfStatm> on line " + lineNum;
    } /* End of identify */

} /* End of class */
