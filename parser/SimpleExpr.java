package parser;

public class SimpleExpr extends PascalSyntax{

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override public String identify() {
        return "<SimpleExpr> on line " + lineNum;
    } /* End of identify */

}/*End class*/
