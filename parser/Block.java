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
        block.constDeclPart = ConstDeclPart.parse(s);
        block.varDeclPart = VarDeclPart.parse(s);
        block.funcDecl = FuncDecl.parse(s);
        block.procDecl = ProcDecl.parse(s);

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

    }/*End prettyPrint*/

}/*End class*/
