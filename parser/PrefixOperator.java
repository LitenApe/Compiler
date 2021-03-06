package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class PrefixOperator extends Operator{

    // a (+) or (-) token plz master

    public TokenKind prefix = null;

    public PrefixOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void genCode(CodeFile f){
        if(prefix == subtractToken)
            f.genInstr("", "negl", "%eax", "  - (prefix)");
    }

    @Override
    public void check(Block curScope, Library lib){
        type = lib.integerType;
    }

    @Override
    public String identify() {
        return "<prefix opr> on line " + lineNum;
    } /* End of identify */

    public static PrefixOperator parse(Scanner s) {
        enterParser("prefix opr");

        PrefixOperator po = new PrefixOperator(s.curLineNum());

        if(s.curToken.kind.isPrefixOpr()){
            po.prefix = s.curToken.kind;
            s.skip(po.prefix);
        }else{
            Main.error("Expected a prefix operator on line " + s.curLineNum() + ", but found: " + s.curToken.kind.toString());
        }

        leaveParser("prefix opr");
        return po;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(prefix.toString());
    }/*End prettyPrint*/

}/*End class*/
