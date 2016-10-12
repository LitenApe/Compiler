package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class RelOperator extends Operator{

    public TokenKind opr = null;

    public RelOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<RelOperator> on line " + lineNum;
    } /* End of identify */

    public static RelOperator parse(Scanner s) {
        enterParser("rel opr");

        RelOperator rOpr = new RelOperator(s.curLineNum());

        if(s.curToken.kind.isRelOpr()){
            rOpr.opr = s.curToken.kind;
        }

        s.skip(rOpr.opr);

        leaveParser("rel opr");
        return rOpr;
    }/*End parse*/

    @Override
    public void prettyPrint() {
    }
}/*End class*/
