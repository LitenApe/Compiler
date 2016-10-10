package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public ArrayList<Expression> exp = new ArrayList<>();
    public NamedConst namedConst = null;

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<ProcCallStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {
        // Main.log.prettyIndent();
        // Main.log.prettyPrint(name);
        // for (Expression e : exp){
        //     e.prettyPrint();
        // }
        // Main.log.prettyOutdent();
        System.out.println("Proc call");
        if(namedConst != null){
            Main.log.prettyPrint(namedConst.name +"(");
            for(Expression ep : exp){
                if(ep != null){
                    ep.prettyPrint();
                }
            }
            Main.log.prettyPrintLn(");");
        }
    }

    public static ProcCallStatm parse(Scanner s) {
        enterParser("proc call");
        ProcCallStatm procCall = new ProcCallStatm(s.curLineNum());

        procCall.namedConst = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            s.skip(leftParToken);
            while(true){
                Expression exprsn = new Expression(s.curLineNum());
                exprsn.parse(s);
                procCall.exp.add(exprsn);

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
