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

        // if(s.curToken == "fdsa"){
        //
        // }else if(s.curToken == "compoundstatm"){
        //
        // }else if(s.curToken == "emptystatm"){
        //
        // }else if(s.curToken == "ifstatm"){
        //
        // }else if(s.curToken == "proccall"){
        //
        // }else if(s.curToken == "whilestatm"){
        //
        // }

        leaveParser("statm list");
        return null;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
} /* End of class */
