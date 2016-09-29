package parser;

public class CompoundStatm extends Statement{

    public CompoundStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<CompoundStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
