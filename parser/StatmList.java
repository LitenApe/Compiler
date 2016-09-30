package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class StatmList extends PascalSyntax{

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> on line " + lineNum;
    } /* End of identify */

    public static StatmList parse(Scanner s){
        enterParser("statm list");

        if(s.curToken.getTokenKind() == assignToken){

        // }else if(s.curToken.getTokenKind() == compoundToken){

        // }else if(s.curToken == emptyToken){
        
        }else if(s.curToken.getTokenKind() == ifToken){

        // }else if(s.curToken == procToken){

        }else if(s.curToken.getTokenKind() == whileToken){

        }

        leaveParser("statm list");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
