package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public ArrayList<Expression> exp = new ArrayList<>();
    public NamedConst namedConst = null;
    public ProcDecl procRef = null;

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Proc Call");

        PascalDecl d = curScope.findDecl(namedConst.toString(), this);

        procRef = (ProcDecl) d;

        if (procRef == null)
            System.out.println("FYCK");

    }

    @Override public String identify() {
        return "<ProcCallStatm> on line " + lineNum;
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

        if (procCall.namedConst.toString().equalsIgnoreCase("write")){
            Library.write = procCall;
        }
        leaveParser("proc call");
        return procCall;
    }

} /* End of class */
