package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class FactorOperator extends Operator{

    TokenKind tokenKind = null;

    public FactorOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] Factor Operator");
    }

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
            Main.error("Expected a factor operator on + " + s.curLineNum() + ", but found :" + s.curToken.kind.toString()); // TODO: This need to fail.
        }

        leaveParser("factor opr");
        return fOpr;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(" " + tokenKind.toString() + " ");
    }/*End prettyPrint*/

}/*End class*/
