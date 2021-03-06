package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class FactorOperator extends Operator{

    TokenKind tokenKind = null;
    types.Type type = null;

    public FactorOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){
    }

    @Override
    public void check(Block curScope, Library lib){
        if(tokenKind == andToken){
            type = lib.booleanType;
        }else{
            type = lib.integerType;
        }
    }

    @Override
    public String identify() {
        return "<factor opr> on line " + lineNum;
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
