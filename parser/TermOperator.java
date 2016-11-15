package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class TermOperator extends Operator{

    TokenKind tokenKind = null;

    public TermOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[ ] Term Operator");
        switch(tokenKind){
                
        }
    }

    @Override
    public void check(Block curScope, Library lib){
        type = tokenKind == orToken ? lib.booleanType : lib.integerType;
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(" " + tokenKind.toString() + " ");
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<term opr> on line " + lineNum;
    } /* End of identify */

    public static TermOperator parse(Scanner s) {
        enterParser("term opr");

        TermOperator operator = new TermOperator(s.curLineNum());

        s.test(s.curToken.kind);
        if(s.curToken.kind.isTermOpr()){
            operator.tokenKind = s.curToken.kind;
            s.skip(s.curToken.kind);
        }else{
            Main.error("Expected a term operator on line: " + s.curLineNum() + ", but found: " + s.curToken.kind.toString()); // TODO: THIS SHIT NEEDS TO FAIL
        }

        leaveParser("term opr");
        return operator;
    }/*End parse*/

}/*End class*/
