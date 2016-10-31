package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class PrefixOperator extends Operator{

    public TokenKind prefix = null;

    public PrefixOperator(int n){
        super(n);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Prefix Operator");
        // System.out.println("PrefixOperator: " + prefix.toString());
    }

    @Override
    public String identify() {
        return "<PrefixOperator> on line " + lineNum;
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
