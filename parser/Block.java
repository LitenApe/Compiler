package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart = null;
    public VarDeclPart varDeclPart = null;
    public StatmList statmList = null;
    public ArrayList<ProcDecl> procAndFuncDecls;

    public Block(int lineNum){
        super(lineNum);
        procAndFuncDecls = new ArrayList<>();
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
                block.procAndFuncDecls.add(FuncDecl.parse(s));
            }
            if (s.curToken.kind == procedureToken){
                block.procAndFuncDecls.add(ProcDecl.parse(s));
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

        if((constDeclPart != null || varDeclPart != null) && procAndFuncDecls != null){
            Main.log.prettyPrintLn("");
        }

        if(procAndFuncDecls != null){
            for (ProcDecl p : procAndFuncDecls)
                p.prettyPrint();
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
