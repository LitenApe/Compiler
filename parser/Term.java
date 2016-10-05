package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class Term extends PascalSyntax{

    public ArrayList<Factor> factrs = new ArrayList<>();
    public ArrayList<FactorOperator> facOps = new ArrayList<>();

    public Term(int n){
        super(n);
    } /* End of constructor */

    public static Term parse(Scanner s){
        enterParser("term");

        Term trm = new Term(s.curLineNum());

        if(s.curToken.kind == nameToken ||
            s.curToken.kind == intValToken ||
            s.curToken.kind == charValToken){
                Factor.parse(s);
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

    }/*End prettyPrint*/
} /* End of class */
