package parser;

import java.util.ArrayList;
import scanner.*;
import static scanner.TokenKind.*;

public class SimpleExpr extends PascalSyntax{

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

    }/*End prettyPrint*/

    public static SimpleExpr parse(Scanner s){
        enterParser("simple expr");

        SimpleExpr simExpr = new SimpleExpr(s.curLineNum());

        if(s.curToken.kind == addToken){
            simExpr.prefix.add(addToken);
            s.skip(addToken);
        }else if(s.curToken.kind == subtractToken){
            simExpr.prefix.add(subtractToken);
            s.skip(subtractToken);
        }

        while(true){
            simExpr.trm.add(Term.parse(s));
            s.readNextToken();

            if(s.curToken.kind != addToken &&
                s.curToken.kind != subtractToken &&
                s.curToken.kind != orToken){
                break;
            }

            simExpr.prefix.add(s.curToken.kind);
            s.readNextToken();
        }

        leaveParser("simple expr");
        return simExpr;
    }
}/*End class*/
