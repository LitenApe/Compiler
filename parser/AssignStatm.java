public class AssignStatm extends Statement{
    
    public AssignStatm(){
        super();
    } /* End of constructor */

    @Override public String identify() {
        return "<AssignStatm> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
