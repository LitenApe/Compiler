package parser;

import scanner.Scanner;

public class VarDeclPart extends PascalSyntax{

    public VarDeclPart(int n){
        super(n);
    } /* End of constructor */

    @Override public String identify() {
        return "<VarDeclPart> on line " + lineNum;
    } /* End of identify */

    public static VarDeclPart parse(Scanner s){
        //Added method definition for compilation
        return null;
    }/*End parse*/

} /* End of class */
