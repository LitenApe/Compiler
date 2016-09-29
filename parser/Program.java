/**
* Program
* Initial stuff is happening here
*/

package parser;

import main.Main;
import scanner.Scanner;

public class Program extends PascalDecl{
    Block proBlock;
    Scanner s;

    public Program(String id, int lNum){
        super(id, lNum);
    } /* End of constructor */

    public Program parse(Scanner s){
        this.s = s;
    } /* End of parse */

    @Override public String identify() {
        return "<program> " + this.name + " on line " + this.lineNum;
    } /* End of identify */

}/*End class*/
