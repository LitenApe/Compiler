package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class IfStatm extends Statement{

    // if : expression : then : statement : else : statement
    Expression exp = null;

    public IfStatm(int n){
        super(n);
    } /* End of public */

    public static IfStatm parse(Scanner s) {
        enterParser("if statm");

        IfStatm ifStat = new IfStatm(s.curLineNum());

        s.skip(ifToken);
        ifStat.exp = Expression.parse(s);

        

        leaveParser("if statm");
        return ifStat;
    }/*End parse*/

    @Override public String identify() {
        return "<IfStatm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {

    }

} /* End of class */
