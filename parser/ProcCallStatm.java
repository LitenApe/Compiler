public class ProcCallStatm extends Statement{

    public ProcCallStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<ProcCallStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
