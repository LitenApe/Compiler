package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart = null;
    public VarDeclPart varDeclPart = null;
    public StatmList statmList = null;
    public ArrayList<ProcDecl> procAndFuncDecls = new ArrayList<>();

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
                block.procAndFuncDecls.add(FuncDecl.parse(s));
            }else if (s.curToken.kind == procedureToken){
                block.procAndFuncDecls.add(ProcDecl.parse(s));
            }else{
                Main.error("Error on line " + s.curLineNum() + ": Expected a begin but found a " + s.curToken.kind.toString() + "!");
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

        if((constDeclPart != null || varDeclPart != null) && procAndFuncDecls.size() > 0){
            Main.log.prettyPrintLn("");
        }

        if(procAndFuncDecls.size() > 0){
            for (ProcDecl p : procAndFuncDecls){
                p.prettyPrint();
                Main.log.prettyPrintLn("");
            }
        }

        Main.log.prettyPrintLn("begin");
        Main.log.prettyIndent();

        statmList.prettyPrint();

        Main.log.prettyOutdent();
        Main.log.prettyPrint("end");
    }/*End prettyPrint*/

}/*End class*/
