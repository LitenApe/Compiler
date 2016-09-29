package parser;

public abstract class Statement extends PascalSyntax{

    public Statement(int n){
        super(n);
    }/*End constructor*/

    @Override public String identify() {
        return "<Statement> on line " + lineNum;
    } /* End of identify */

}/*End class*/
