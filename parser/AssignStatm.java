package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.*;
import types.*;

public class AssignStatm extends Statement{

    // variable : := : expression

    public Variable variable = null;
    public Expression expression = null;

    public AssignStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-] Assign Statement");
        expression.genCode(f);

        if(variable.type instanceof types.ArrayType){
            f.genInstr("", "pushl", "%eax", "ArrayType operation");
            variable.genCode(f);
            f.genInstr("", "subl", "$low,%eax", "Dropp om low = 0");    //NOTE: Hva er low?? :P
            f.genInstr("", "movl", (-4*variable.decl.declLevel)+"(%ebp),%edx", "");
            f.genInstr("", "leal", (-1*(32+variable.decl.declOffset))+"(%edx),%edx", "");
            f.genInstr("", "popl", "%ecx", "");
            f.genInstr("", "movl", "%ecx,(%edx,%eax,4)", "");
        }else{
        //TODO: Fix this or wherever it is, decl level is always 1 less in this assignstatm for easter.s
            f.genInstr("","movl",""+(-4*variable.decl.declLevel)+"(%ebp),%edx","");
            f.genInstr("","movl","%eax,"+(-1*(32+variable.decl.declOffset))+"(%edx)",variable.name.name+ " " +assignToken);
        }
    }

    @Override
    public void check(Block curScope, Library lib){
        variable.check(curScope,lib);
        expression.check(curScope,lib);

        if(variable.decl instanceof ConstDecl){
            error("You cannot assign to a constant");
        }

        type = variable.type;
        type.checkType(type, ":=", expression, "Value and expression is of different types");
    }

    @Override
    public void prettyPrint(){
        variable.prettyPrint();
        Main.log.prettyPrint(" := ");
        expression.prettyPrint();
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<assign statm> on line " + lineNum;
    } /* End of identify */

    public static AssignStatm parse(Scanner s) {
        enterParser("assign statm");

        AssignStatm as = new AssignStatm(s.curLineNum());

        as.variable = Variable.parse(s);

        s.skip(assignToken);

        as.expression = Expression.parse(s);
        leaveParser("assign statm");
        return as;
    }/*End parse*/

} /* End of class */
