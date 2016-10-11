package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class SimpleExpr extends PascalSyntax{

    // prefix opr : term : term opr

    public ArrayList<TokenKind> prefix = new ArrayList<>();
    public ArrayList<Term> trm = new ArrayList<>();
    public ArrayList<SimpleExpr> simplLst = new ArrayList<>();

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override public String identify() {
        return "<SimpleExpr> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("Simple Expression");
    }/*End prettyPrint*/

    public static SimpleExpr parse(Scanner s){
        enterParser("simple expr");

        SimpleExpr simExpr = new SimpleExpr(s.curLineNum());

        if(s.curToken.kind.isPrefixOpr()){
            simExpr.prefix.add(s.curToken.kind);
            s.skip(simExpr.prefix.get(simExpr.prefix.size() - 1));
        }

        while(true){
            simExpr.trm.add(Term.parse(s));

            if(!s.curToken.kind.isTermOpr()){
                break;
            }

            simExpr.prefix.add(s.curToken.kind);
        }
        leaveParser("simple expr");
        return simExpr;
    }
}/*End class*/
