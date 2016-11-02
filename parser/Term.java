package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class Term extends PascalSyntax{

    public ArrayList<Factor> factors = new ArrayList<>();
    public ArrayList<FactorOperator> factorOpr = new ArrayList<>();
    public types.Type type;

    public Term(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[-] Term");
        for(int i = 0; i < factors.size(); i++){
            factors.get(i).check(curScope, lib);
            type = factors.get(i).type;
            if(i < factorOpr.size()){
                factorOpr.get(i).check(curScope, lib);
                type.checkType(factors.get(i).type, "left "+factorOpr.get(i).tokenKind.toString()+" operand", this, "parameter not same!"); //NOTE: wut?
            }
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
        return "<term> on line " + lineNum;
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
