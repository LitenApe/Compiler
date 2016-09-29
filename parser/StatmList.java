package parser;

import scanner.Scanner;

public class StatmList extends PascalSyntax{

    public StatmList(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<StatmList> on line " + lineNum;
    } /* End of identify */

    public static StatmList parse(Scanner s){
        //Added method definition for compilation
        return null; 
    }/*End parse*/
} /* End of class */
