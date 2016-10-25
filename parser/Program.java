/**
* Program
* Initial stuff is happening here
*/
package parser;

import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class Program extends PascalDecl{
    Block progBlock = null;
    NamedConst progName = null;
    Scanner s = null;

    public Program(String id, int lNum){
        super(id, lNum);
    } /* End of constructor */

    public static Program parse(Scanner s){
        enterParser("program");
        s.skip(programToken);

        Program p = new Program(s.curToken.id, s.curLineNum());
        p.progName = NamedConst.parse(s);

        s.skip(semicolonToken);

        p.progBlock = Block.parse(s);
        // p.progBlock.context = p;
        s.skip(dotToken);

        leaveParser("program");
        return p;
    } /* End of parse */

    public void check(Library uno, Library dos){
        System.out.println("Program");
        progBlock.check(uno, dos);
    }

    @Override
    public String identify() {
        return "<program> " + name + " on line " + lineNum;
    } /* End of identify */

    @Override
    public void checkWhetherAssignable(PascalSyntax where){

    }/*End checkWhetherAssignable*/

    @Override
    public void checkWhetherFunction(PascalSyntax where){

    }/*End checkWhetherFunction*/

    @Override
    public void checkWhetherProcedure(PascalSyntax where){

    }/*End checkWhetherProcedure*/

    @Override
    public void checkWhetherValue(PascalSyntax where){

    }/*End checkWhetherValue*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrintLn("program " + progName.name + ";");
        progBlock.prettyPrint();
        Main.log.prettyPrint(".");
    }/*End prettyPrint*/
}/*End class*/
