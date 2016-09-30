package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Constant extends PascalSyntax{

    PrefixOperator prefixOpr;
    UnsignedConstant uConstant;

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify(){
        return "<constant> on line " + lineNum;
    }/*End identify*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    public static Constant parse(Scanner s){
        enterParser("constant");

        Constant constant = new Constant(s.curLineNum());
        constant.prefixOpr = PrefixOperator.parse(s);
        constant.uConstant = UnsignedConstant.parse(s);

        System.out.println(constant.identify());

        leaveParser("constant");
        return null; //remember changing back
    }
}/*End class*/
