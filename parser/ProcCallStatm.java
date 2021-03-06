package parser;

import java.util.ArrayList;
import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public NamedConst namedConst = null;
    public ArrayList<Expression> exp = new ArrayList<>();
    public ProcDecl procRef = null;

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void genCode(CodeFile f){
        int counter = 0;

        if(exp.isEmpty())
            f.genInstr("", "call", "proc$"+procRef.label, "");
        else if(exp.isEmpty() && !namedConst.name.equals("write"))
            procRef.genCode(f);

        if(namedConst.name.equals("write")){
            for(Expression e : exp){
                e.genCode(f);
                f.genInstr("", "pushl", "%eax", "Push next param.");

                if (e.type != null){
                    String sType = e.type.toString();
                    if(sType.equals("integer") ||
                            sType.equals("character") ||
                                sType.equals("boolean"))
                       f.genInstr("", "call", e.type.writeCMD(), ""); //smart
                    else
                       error(sType + " is a invalid type that encountered during writing");
                }
                f.genInstr("", "addl","$4,%esp", "Pop param.");
            }
        }else{
            for(int i = exp.size() - 1; i >= 0; i--){
                exp.get(i).genCode(f);
                f.genInstr("", "pushl", "%eax", "Push param #" + (i + 1)+".");
            }
            if(exp.size() != 0){
                f.genInstr("", "call","proc$"+procRef.label, "");//Null pointer because decl assembly hasnt been done yet
                f.genInstr("", "addl","$"+(4*exp.size())+",%esp", "Pop params.");
            }
        }
    }

    @Override
    public void check(Block curScope, Library lib){
        namedConst.check(curScope, lib);

        PascalDecl pd = curScope.findDecl(namedConst.toString(), this);
        procRef = (ProcDecl) pd;

        ArrayList<ParamDecl> list = null;

        if (procRef.paramDecl != null)
            list = procRef.paramDecl.listOfParamDecls;

        if((exp != null && list != null) && exp.size() != list.size()){
            String msg = exp.size() < procRef.paramDecl.listOfParamDecls.size() ? "few":"many";
            error("Too " + msg + " parameters in call on " + namedConst.name);
        }

        for(Expression e : exp){
            e.check(curScope, lib);
            if (list != null){
                types.Type t = list.get(exp.indexOf(e)).type;
                t.checkType(e.type,"param #"+(exp.indexOf(e)+1),this,"Param type mismatch!");
            }
        }
    }

    @Override public String identify() {
        return "<proc call statm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {
        namedConst.prettyPrint();
        if (!exp.isEmpty()) {
            Main.log.prettyPrint("(");
            for(Expression ep : exp){
                ep.prettyPrint();
                if(ep != exp.get(exp.size() - 1)){
                    Main.log.prettyPrint(", ");
                }
            }
            Main.log.prettyPrint(")");
        }
    }

    public static ProcCallStatm parse(Scanner s) {
        enterParser("proc call");
        ProcCallStatm procCall = new ProcCallStatm(s.curLineNum());

        procCall.namedConst = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            s.skip(leftParToken);
            while(true){
                procCall.exp.add(Expression.parse(s));

                if(s.curToken.kind != commaToken){
                    break;
                }else{
                    s.skip(commaToken);
                }
            }
            s.skip(rightParToken);
        }

        leaveParser("proc call");
        return procCall;
    }

} /* End of class */
