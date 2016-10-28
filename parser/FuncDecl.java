package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class FuncDecl extends ProcDecl{

    // function : name : param decl list : : : type name : ; : block : ;
    public NamedConst funcName = null;
    public ParamDeclList pDeclList = null;
    public TypeName typeName = null;
    public Block block = null;

    public FuncDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void check(Block curScope, Library lib){
        funcName.check(curScope,lib);
        if (pDeclList != null)
            pDeclList.check(block,lib);
        typeName.check(block,lib);
        block.check(curScope,lib);
        
        curScope.addDecl(name.toString(),this);
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint("function ");
        funcName.prettyPrint();

        if (pDeclList != null){
            pDeclList.prettyPrint();
        }

        Main.log.prettyPrint(": ");
        typeName.prettyPrint();
        Main.log.prettyPrintLn(";");
        block.prettyPrint();
        Main.log.prettyPrint("; {");
        funcName.prettyPrint();
        Main.log.prettyPrintLn("}");
    }/*End prettyPrint*/

    public static FuncDecl parse(Scanner s){
        enterParser("func decl");

        s.skip(functionToken);

        FuncDecl fDecl = new FuncDecl(s.curToken.id, s.curLineNum());
        fDecl.funcName = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            fDecl.pDeclList = ParamDeclList.parse(s);
        }
        s.skip(colonToken);
        fDecl.typeName = TypeName.parse(s);
        s.skip(semicolonToken);
        fDecl.block = Block.parse(s);
        s.skip(semicolonToken);

        leaveParser("func decl");
        return fDecl;
    }/*End parse*/

    @Override
    public String toString(){
        return funcName.toString();
    }

    @Override
    public String identify() {
        return "<func decl> " + name + " on line " + lineNum;
    } /* End of identify */

    //TODO: this class doesnt override any of the 4 abstract methods in ProcDecl
    //which is inherited from PascalDecl. If needed, we need to implement this
    //later
}/*End class*/
