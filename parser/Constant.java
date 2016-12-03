package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class Constant extends PascalSyntax{

    // prefix opr : unsigned opr

    PrefixOperator prefixOpr;
    UnsignedConstant uConstant;
    types.Type type;
    int constVal;
    PascalDecl decl;

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        uConstant.genCode(f);
        if (prefixOpr != null)
            prefixOpr.genCode(f);
    }

    @Override
    public void check(Block curScope, Library lib){
        uConstant.check(curScope, lib);
        type = uConstant.type;

        constVal = uConstant.constVal;
        if(uConstant instanceof NamedConst)
            decl = curScope.findDecl(uConstant.name, this);

        if (prefixOpr != null) {
            String oprName = prefixOpr.prefix.toString();
            uConstant.type.checkType(lib.integerType, "Prefix "+oprName, this,"Prefix + or - may only be applied to Integers.");

            if (prefixOpr.prefix == subtractToken)
                constVal = -constVal;
        }
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
