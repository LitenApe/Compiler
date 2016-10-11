package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class ParamDeclList extends PascalSyntax{

    ArrayList<ParamDecl> listOfParamDecls;

    public ParamDeclList(int n){
        super(n);
        listOfParamDecls = new ArrayList<>();
    }

    @Override
    public String identify() {
        return "<ParamDeclList> on line " + lineNum;
    } /* End of identify */

    public static ParamDeclList parse(Scanner s){
        enterParser("param decl list");

        ParamDeclList pDeclList = new ParamDeclList(s.curLineNum());
        s.skip(leftParToken);

        while (s.curToken.kind != rightParToken){
            listOfParamDecls.add(ParamDecl.parse(s));

            if (s.curToken.kind == semicolonToken){
                s.skip(semicolonToken);
            }
        }

        s.skip(rightParToken);
        leaveParser("param decl list");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}
