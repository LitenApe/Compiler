package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class TermOperator extends Operator{

    TokenKind tokenKind = null;

    public TermOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<CompoundStatm> on line " + lineNum;
    } /* End of identify */

    public static TermOperator parse(Scanner s) {
        enterParser("term opr");

        TermOperator operator = new TermOperator(s.curLineNum());
        s.test(s.curToken.kind);
        if(s.curToken.kind.isTermOpr()){
            operator.tokenKind = s.curToken.kind;
            s.skip(s.curToken.kind);
        }else{
            s.skip(s.curToken.kind); // TODO: THIS SHIT NEEDS TO FAIL
        }
        leaveParser("term opr");
        return operator;
    }/*End parse*/

    //TODO: prettyPrint?
}/*End class*/
