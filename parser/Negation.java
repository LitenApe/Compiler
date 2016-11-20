package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;
import types.BoolType;

public class Negation extends Factor{

    Factor factor = null;

    public Negation(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){
        System.out.println("[x] Negation: ----- : not");
        f.genInstr("", "xorl", "$1,%eax", "  not");
    }

    @Override
    public String identify() {
        return "<negation> on line " + lineNum;
    } /* End of identify */

    @Override
    public void check(Block curScope, Library lib){
        factor.check(curScope,lib);
        type = lib.booleanType;
        type.checkType(factor.type, "'not' operand",this,"Expected boolean found: "+factor.type);
    }

    public static Negation parse(Scanner s) {
        enterParser("negation");

        s.skip(notToken);
        Negation negation = new Negation(s.curLineNum());
        negation.factor = Factor.parse(s);

        leaveParser("negation");
        return negation;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("not ");
        factor.prettyPrint();
    }/*End prettyPrint*/
}/*End class*/
