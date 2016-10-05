package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public ArrayList<Expression> exp = new ArrayList<>();
    public String name = "";

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<ProcCallStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {

    }

    public static ProcCallStatm parse(Scanner s) {
        enterParser("proc call");
        ProcCallStatm procCall = new ProcCallStatm(s.curLineNum());

        s.test(nameToken);
        procCall.name = s.curToken.id;
        s.skip(nameToken);

        if(s.curToken.kind == leftParToken){
            s.skip(leftParToken);
            while(true){
                Expression exprsn = new Expression(s.curLineNum());
                exprsn.parse(s);
                procCall.exp.add(exprsn);

                if(s.curToken.kind != commaToken){
                    break;
                }
            }

            s.skip(rightParToken);
        }

        leaveParser("proc call");
        return procCall; //TODO: Return instance ProcCallStatm
    }

} /* End of class */
