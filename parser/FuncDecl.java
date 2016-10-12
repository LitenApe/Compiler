package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class FuncDecl extends ProcDecl{

    // function : name : param decl list : : : type name : ; : block : ;
    public NamedConst funcName = null;
    public ParamDeclList pDclLst = null;
    public TypeName tName = null;
    public Block blk = null;

    public FuncDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public String identify() {
        return "<FuncDecl> " + name + " on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("function ");
        funcName.prettyPrint();

        if (pDclLst != null){
            pDclLst.prettyPrint();
        }

        Main.log.prettyPrint(": ");
        tName.prettyPrint();
        Main.log.prettyPrintLn(";");
        blk.prettyPrint();
        Main.log.prettyPrintLn(";");
    }/*End prettyPrint*/

    public static FuncDecl parse(Scanner s){
        enterParser("func decl");

        s.skip(functionToken);

        FuncDecl fDcl = new FuncDecl(s.curToken.id, s.curLineNum());
        fDcl.funcName = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            fDcl.pDclLst = ParamDeclList.parse(s);
        }
        s.skip(colonToken);
        fDcl.tName = TypeName.parse(s);
        s.skip(semicolonToken);
        fDcl.blk = Block.parse(s);
        s.skip(semicolonToken);

        leaveParser("func decl");
        return fDcl;
    }/*End parse*/

    //TODO: this class doesnt override any of the 4 abstract methods in ProcDecl
    //which is inherited from PascalDecl. If needed, we need to implement this
    //later
}/*End class*/
