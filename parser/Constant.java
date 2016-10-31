package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Constant extends PascalSyntax{

    // prefix opr : unsigned opr

    PrefixOperator prefixOpr;
    UnsignedConstant uConstant;

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Constant");
    }

    @Override
    public void prettyPrint(){
        if (prefixOpr != null){
            prefixOpr.prettyPrint();
        }
        uConstant.prettyPrint();
    }/*End prettyPrint*/

    @Override
    public String identify(){
        return "<constant> on line " + lineNum;
    }/*End identify*/

    public static Constant parse(Scanner s){
        enterParser("constant");

        Constant constant = new Constant(s.curLineNum());
        if (s.curToken.kind.isPrefixOpr()) {
            constant.prefixOpr = PrefixOperator.parse(s);
        }
        constant.uConstant = UnsignedConstant.parse(s);
        leaveParser("constant");
        return constant; //remember changing back
    }
}/*End class*/
