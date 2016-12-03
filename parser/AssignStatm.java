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
        expression.genCode(f);

        if(variable.expression != null){
            //TODO: Hvordan referere til variabelens arraytype slik at man kan hente types.ArrayType.size() blant annet
            f.genInstr("", "pushl", "%eax", "ArrayType operation");
            variable.expression.genCode(f);
            VarDecl d = ((VarDecl)variable.decl);
            int low = ((ArrayType)d.mType).preConstant.constVal;
            // int baseOffset = ((ArrayType)d.mType).type.size();
            // TODO: For aa finne ut hva størrelsen er må vi ha (low-high)+1; se linjen over med type.size().
            // Hvis low og high er riktig satt er formelen (...).type.size()*4, som byttes ut med leal-linjen
            // NOTE: Arrays er ikke gjort.
            f.genInstr("", "subl", "$"+low+",%eax", "Dropp om low = 0");    //NOTE: Hva er low?? :P. Det er preconst sin verdi (constval); see check() in parser.ArrayType.java :D
            f.genInstr("", "movl", (-4*variable.decl.declLevel)+"(%ebp),%edx", "");
            f.genInstr("", "leal", (-1*(32+variable.decl.declOffset))+"(%edx),%edx", "");
            f.genInstr("", "popl", "%ecx", "");
            f.genInstr("", "movl", "%ecx,(%edx,%eax,4)", "");
        }else{
            f.genInstr("","movl",""+(-4*variable.decl.declLevel)+"(%ebp),%edx","");
            if(variable.expression == null)
                f.genInstr("","movl","%eax,"+(-1*(32+variable.decl.declOffset))+"(%edx)",variable.name.name+ " " +assignToken);
            else
                f.genInstr("","movl","%eax,"+(-1*(32+variable.decl.declOffset))+"(%edx)",variable.name.name+ "[x] " +assignToken);
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
