package parser;

import scanner.*;
import main.*;
import static scanner.TokenKind.*;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart;
    public VarDeclPart varDeclPart;
    public FuncDecl funcDecl;
    public ProcDecl procDecl;
    public StatmList statmList;

    public Block(int lineNum){
        super(lineNum);
    }/*End constructor*/

    public static Block parse(Scanner s){
        enterParser("block");

        //Instanciate a new block to return to caller
        Block block = new Block(s.curLineNum());
        //Return instances of instance variables
        ////TODO: Check if s.skip(endToken) should be prior or after
        s.skip(beginToken);
        switch(s.curToken.kind){
            case constToken:
                block.constDeclPart = ConstDeclPart.parse(s);
                break;
            case varToken:
                block.varDeclPart = VarDeclPart.parse(s);
                break;
            case functionToken:
                block.funcDecl = FuncDecl.parse(s);
                break;
            case procedureToken:
                block.procDecl = ProcDecl.parse(s);
                break;
            default:
                block.statmList = StatmList.parse(s);
        }

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

    }/*End prettyPrint*/

}/*End class*/
