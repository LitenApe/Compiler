package parser;

public class EmptyStatm extends Statement{

    public EmptyStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<EmptyStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
