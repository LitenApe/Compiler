/**
* Program
* Initial stuff is happening here
*/
package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public class Program extends PascalDecl{
    Block progBlock = null;
    NamedConst progName = null;
    Scanner s = null;

    public Program(String id, int lNum){
        super(id, lNum);
    } /* End of constructor */

    @Override
    public void genCode(CodeFile f){
        System.out.println("[-] Program: " + progName);
        progBlock.declLevel = 1;
        String testLabel = "prog$" + f.getLabel(progName.name);
        
        f.genInstr("", ".globl", "main", "");
        f.genInstr("main", "", "", "");
        f.genInstr("", "call ", testLabel, "Start program");
        f.genInstr("", "movl", "$0,%eax", "Set status 0 and");
        f.genInstr("", "ret", "", "terminate the program");

        if(!progBlock.procAndFuncDecls.isEmpty()){
            for(ProcDecl pd : progBlock.procAndFuncDecls){
                pd.genCode(f);
            }
        }

        f.genInstr(testLabel, "", "", "");
        int numBytes = progBlock.varDeclPart != null ? 32+progBlock.varDeclPart.varDecls.size()*4 : 32;
        f.genInstr("", "enter", "$" + numBytes + ",$" + declLevel, "Start of " + progName.name + "");

        progBlock.genCode(f);

        f.genInstr("", "leave", "", "End of " + progName.name);
        f.genInstr("", "ret", "", "");
    }

    @Override
    public void check(Block curScope, Library lib){
        progName.check(curScope, lib);
        progBlock.check(curScope, lib);
    }

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
