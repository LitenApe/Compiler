package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class Term extends PascalSyntax{

    public ArrayList<Factor> factors = new ArrayList<>();
    public ArrayList<Operator> factorOpr = new ArrayList<>();

    public Term(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        for(PascalSyntax ps : factors){
            ps.check(curScope, lib);
            System.out.println(ps.identify());
        }
    }

    public static Term parse(Scanner s){
        enterParser("term");

        Term term = new Term(s.curLineNum());

        term.factors.add(Factor.parse(s));

        while(s.curToken.kind.isFactorOpr()) {
            term.factorOpr.add(FactorOperator.parse(s));
            term.factors.add(Factor.parse(s));
        }

        leaveParser("term");
        return term;
    }

    @Override
    public String identify() {
        return "<Term> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        for(int i = 0; i < factors.size(); i++){
            factors.get(i).prettyPrint();
            if(i < factorOpr.size())
                factorOpr.get(i).prettyPrint();
        }
    }/*End prettyPrint*/
} /* End of class */
