package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FactorOperator extends Operator{

    public FactorOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<FactorOperator> on line " + lineNum;
    } /* End of identify */

    public static FactorOperator parse(Scanner s) {
        enterParser("factor opr");

        FactorOperator fOpr = null;

        if(s.curToken.kind.isFactorOpr()){
            fOpr = new FactorOperator(s.curLineNum());
            s.skip(s.curToken.kind);
        }else{
            s.skip(s.curToken.kind);
        }

        leaveParser("factor opr");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

}/*End class*/
