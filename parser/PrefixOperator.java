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
            // FEIL
            Main.error("FDSAFS");
        }

        leaveParser("prefix opr");
        return po;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(prefix.toString());
    }/*End prettyPrint*/

}/*End class*/
