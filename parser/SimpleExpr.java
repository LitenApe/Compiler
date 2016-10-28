package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;
import types.*;

public class SimpleExpr extends PascalSyntax{

    // prefix opr : term : term opr
    public PrefixOperator prefix = null;
    public ArrayList<TermOperator> termOpr = new ArrayList<>();
    public ArrayList<Term> term = new ArrayList<>();
    public types.Type type = null;

    public SimpleExpr(int n){
        super(n);
    }/*End Constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("<simple expr> " + curScope + " : " + term.size());
        if (prefix != null)
            prefix.check(curScope,lib);

        //NOTE: Farlig hvorfor rappe hvis du er så farlig
        for(int i = 0; i < term.size(); i++){
            try{
                term.get(i).check(curScope,lib);
            }catch(Exception e){
                System.out.println("4: Are you the cursed one? - simple expr");
            }

            if(type == null)
                try{
                    type = term.get(i).type;
                }catch(Exception e){
                    System.out.println("1: This muther f is causing a problem - simpl expr");
                }
            else{
                try{
                    Main.log.noteTypeCheck(type, termOpr.get(i - 1).toString(), term.get(i).type, this);
                }catch(Exception e){
                    System.out.println("2: This muther fucker is causing problems - simpl expr");
                }
            }

            if(i < termOpr.size()){
                try{
                    termOpr.get(i).check(curScope,lib);
                }catch(Exception e){
                    System.out.println("3: This piece of shit here is causing the problem - simpl expr");
                }
            }
        }
    }

    @Override public String identify() {
        return "<SimpleExpr> on line " + lineNum;
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
