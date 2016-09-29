package parser;

public abstract class Statement extends PascalSyntax{

    public Statement(int n){
        super(n);
    }/*Enc constructor*/

    @Override public String identify() {
        return "<Statement> " + name + " on line " + lineNum;
    } /* End of identify */

}/*End class*/
