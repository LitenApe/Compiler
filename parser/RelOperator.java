package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.*;

public class RelOperator extends Operator{

    public TokenKind opr = null;
    public types.Type type = null;

    public RelOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){}

    @Override
    public void check(Block curScope, Library lib){
        type = lib.booleanType;
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(" "+opr.toString()+" ");
    }

    @Override
    public String identify() {
        return "<rel opr> on line " + lineNum;
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
}/*End class*/
