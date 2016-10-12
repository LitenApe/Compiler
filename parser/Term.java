package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class Term extends PascalSyntax{

    public ArrayList<PascalSyntax> fac = new ArrayList<>();

    public Term(int n){
        super(n);
    } /* End of constructor */

    public static Term parse(Scanner s){
        enterParser("term");

        Term trm = new Term(s.curLineNum());
        trm.fac.add(Factor.parse(s));

        while(s.curToken.kind.isFactorOpr()) {
            trm.fac.add(FactorOperator.parse(s));
            trm.fac.add(Factor.parse(s));
        }

        leaveParser("term");
        return trm;
    }

    @Override
    public String identify() {
        return "<Term> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        for (PascalSyntax p : fac) {
            p.prettyPrint(); 
        }
    }/*End prettyPrint*/
} /* End of class */
