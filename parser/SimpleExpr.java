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
    public types.Type type;

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override
    public void check(Block curScope, Library lib){
        if (prefix != null)
            prefix.check(curScope,lib);

        for(int i = 0; i < term.size(); i++){
            term.get(i).check(curScope, lib);
            type = term.get(i).type;

            if(i == 0 && prefix != null){
                String image = prefix.prefix.toString().equals("or") ? "'or'" : prefix.prefix.toString();
                prefix.type.checkType(term.get(i).type, "prefix " + image + " operand", this, "Expected integer, found: " + term.get(i).type);
            }

            if(i > 0){
                String image = termOpr.get(i-1).tokenKind.toString().equals("or") ? "'or'" : termOpr.get(i-1).tokenKind.toString();
                type.checkType(term.get(i - 1).type, "left "+image+" operand", this, "parameter not same!");
                type.checkType(term.get(i).type, "right "+image+" operand", this, "parameter not same!");
            }

            if(i < termOpr.size()){
                termOpr.get(i).check(curScope, lib);
                type = termOpr.get(i).type;
            }
        }
    }

    @Override public String identify() {
        return "<simpl expr> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        if (prefix != null){
            Main.log.prettyPrint(" ");
            prefix.prettyPrint();
            Main.log.prettyPrint(" ");
        }

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
