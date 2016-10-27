package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;
import types.Type;

public class Term extends PascalSyntax{

    public ArrayList<Factor> factors = new ArrayList<>();
    public ArrayList<Operator> factorOpr = new ArrayList<>();
    public types.Type type = null;

    public Term(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        for(Factor f : factors){
            f.check(curScope, lib);
            type = f.type;
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
