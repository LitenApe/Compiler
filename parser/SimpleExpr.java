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
        System.out.println("[-] Simple Expr");
        if (prefix != null)
            prefix.check(curScope,lib);
        // type.checkType(secondValue.type,oprName+" operands",this,"Operands to "+oprName+" are of different type!");

        for(int i = 0; i < term.size(); i++){
            term.get(i).check(curScope, lib);
            if(i < termOpr.size()){
                termOpr.get(i).check(curScope, lib);
            }
            type = term.get(i).type; //TODO: define type
            System.out.println("LINE: ---------------------------------"+lineNum);
            System.out.println("TYPE FOR SIMPLE EXPR ---------------------------------"+type);
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
