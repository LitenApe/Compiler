package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class SimpleExpr extends PascalSyntax{

    // prefix opr : term : term opr
    public PrefixOperator prefix = null;
    public ArrayList<TermOperator> termOpr = new ArrayList<>();
    public ArrayList<Term> term = new ArrayList<>();

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override public String identify() {
        return "<SimpleExpr> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        if (prefix != null)
            prefix.prettyPrint();

        for(int i = 0; i < term.size(); i++){
            term.get(i).prettyPrint();
            if(i < termOpr.size()){
                termOpr.get(i).prettyPrint();
            }
        }
    }/*End prettyPrint*/

    public static SimpleExpr parse(Scanner s){
        enterParser("simple expr");

        SimpleExpr simExpr = new SimpleExpr(s.curLineNum());

        if(s.curToken.kind.isPrefixOpr()){
            simExpr.prefix = PrefixOperator.parse(s);
            if(s.curToken.kind.isPrefixOpr()){
                Main.error("Expected a value but found a " + s.curToken.kind.toString() + "!");
            }
        }

        while(true){
            simExpr.term.add(Term.parse(s));

            if(!s.curToken.kind.isTermOpr()){
                break;
            }

            simExpr.termOpr.add(TermOperator.parse(s));
        }

        leaveParser("simple expr");
        return simExpr;
    }
}/*End class*/
