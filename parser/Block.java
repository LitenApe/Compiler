package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart = null;
    public VarDeclPart varDeclPart = null;
    public FuncDecl funcDecl = null;
    public ProcDecl procDecl = null;
    public StatmList statmList = null;

    public Block(int lineNum){
        super(lineNum);
    }/*End constructor*/

    public static Block parse(Scanner s){
        enterParser("block");

        Block block = new Block(s.curLineNum());

        if (s.curToken.kind == constToken){
            block.constDeclPart = ConstDeclPart.parse(s);
        }
        if (s.curToken.kind == varToken){
            block.varDeclPart = VarDeclPart.parse(s);
        }

        while(s.curToken.kind != beginToken){
            if (s.curToken.kind == functionToken){
                block.funcDecl = FuncDecl.parse(s);
            }
            if (s.curToken.kind == procedureToken){
                block.procDecl = ProcDecl.parse(s);
            }
        }

        s.skip(beginToken);
        block.statmList = StatmList.parse(s);
        s.skip(endToken);

        leaveParser("block");
        return block;
    }/*End parse*/

    @Override
    public String identify() {
        return "<Block> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint(){
        if(constDeclPart != null){
            constDeclPart.prettyPrint();
        }
        if(varDeclPart != null){
            varDeclPart.prettyPrint();
        }

        if(constDeclPart != null && varDeclPart != null && funcDecl != null){
            Main.log.prettyPrintLn("");
        }

        if(funcDecl != null){
            funcDecl.prettyPrint();
        }
        if(procDecl != null){
            procDecl.prettyPrint();
        }
        if(statmList != null){
            Main.log.prettyPrintLn("begin");
            Main.log.prettyIndent();
            statmList.prettyPrint();
        }
        Main.log.prettyOutdent();
        Main.log.prettyPrint("end");
    }/*End prettyPrint*/

}/*End class*/
