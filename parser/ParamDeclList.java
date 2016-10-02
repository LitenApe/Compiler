package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class ParamDeclList extends PascalSyntax{

    public ParamDeclList(int n){
        super(n);
    }

    @Override
    public String identify() {
        return "<ParamDeclList> on line " + lineNum;
    } /* End of identify */

    public static ParamDeclList parse(Scanner s){
        enterParser("param decl list");
        leaveParser("param decl list");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}
