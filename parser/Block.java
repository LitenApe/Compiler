package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart = null;
    public VarDeclPart varDeclPart = null;
    public StatmList statmList = null;
    public ArrayList<ProcDecl> procAndFuncDecls = new ArrayList<>();
    public HashMap<String, PascalDecl> decls = new HashMap<>();
    public Block outerScope = null;

    public Block(int lineNum){
        super(lineNum);
    }/*End constructor*/

    public void addDecl(String id, PascalDecl declaration){
        if (decls.containsKey(id))
            declaration.error(id + " declared twice in same block!");
        else
            this.decls.put(id,declaration);
    }

    public PascalDecl findDecl(String id, PascalSyntax where){
        PascalDecl found = decls.get(id);
        System.out.println("in block");
        PascalSyntax found_2 = null;

        if (found != null){
            Main.log.noteBinding(id,where,found);
            return found;
        }

        if (outerScope != null && found == null){
            System.out.println("Instance: "+outerScope.toString());
            found = outerScope.findDecl(id,where);
        }

        if(found == null)
            where.error("Name " + id + " is unknown!");
        return found;
    }

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Block");
        outerScope = curScope;
        if(constDeclPart != null)
            constDeclPart.check(this, lib);

        if(varDeclPart != null)
            varDeclPart.check(this, lib);

        for(ProcDecl p : procAndFuncDecls)
            p.check(curScope,lib);

        statmList.check(this, lib);
    }

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
    public void prettyPrint(){
        if(constDeclPart != null){
            constDeclPart.prettyPrint();
        }
        if(varDeclPart != null){
            varDeclPart.prettyPrint();
        }

        if(procAndFuncDecls.size() > 0){
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

    @Override
    public String identify() {
        return "<Block> on line " + lineNum;
    } /* End of identify */

}/*End class*/
