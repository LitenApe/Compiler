package parser;

import scanner.Scanner;

public class Block extends PascalSyntax{

    public ConstDeclPart constDeclPart;
    public VarDeclPart varDeclPart;
    public FuncDecl funcDecl;
    public ProcDecl procDecl;
    public StatmList statmList; //TODO: just a note Tredje kolonne i foilene, ingen assigned enda

    public Block(int lineNum){
        super(lineNum);
    }/*End constructor*/


    public static Block parse(Scanner s){
        enterParser(s.curToken.id);

        Block block = new Block(s.curLineNum()); //Get line number of block start

        //Return instances
        block.constDeclPart = ConstDeclPart.parse(s);
        block.varDeclPart = VarDeclPart.parse(s);
        block.funcDecl = FuncDecl.parse(s);
        block.procDecl = ProcDecl.parse(s);
        block.statmList = StatmList.parse(s);

        leaveParser(s.curToken.id);

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
