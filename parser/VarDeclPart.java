package parser;

public class VarDeclPart extends PascalSyntax{

    public VarDeclPart(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<VarDeclPart> " + name + " on line " + lineNum;
    } /* End of identify */

} /* End of class */
