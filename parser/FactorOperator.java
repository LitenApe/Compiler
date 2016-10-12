package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class FactorOperator extends Operator{

    TokenKind tokenKind = null;

    public FactorOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<FactorOperator> on line " + lineNum;
    } /* End of identify */

    public static FactorOperator parse(Scanner s) {
        enterParser("factor opr");

        FactorOperator fOpr = new FactorOperator(s.curLineNum());

        if(s.curToken.kind.isFactorOpr()){
            fOpr.tokenKind = s.curToken.kind;
            s.skip(s.curToken.kind);
        }else{
            s.skip(s.curToken.kind); // TODO: This shit need to fail.
        }

        leaveParser("factor opr");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

}/*End class*/
