package parser;

public class AssignStatm extends Statement{

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<AssignStatm> on line " + lineNum;
    } /* End of identify */

} /* End of class */
