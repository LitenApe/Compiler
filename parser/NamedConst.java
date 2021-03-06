package parser;
import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class NamedConst extends UnsignedConstant{

    public String name = "";

    public NamedConst(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void genCode(CodeFile f){}

    @Override
    public void check(Block curScope, Library lib){
        if(name.equals("integer"))
            type = lib.integerType;
        else if(name.equals("boolean") ||
                    name.equals("true") ||
                        name.equals("false"))
            type = lib.booleanType;
        else if(name.equals("char"))
            type = lib.characterType;
        else
            type = lib.integerType;

        super.name = name;
    }

    public static NamedConst parse(Scanner s) {
        // enterParser("named const");
        NamedConst namedConst = new NamedConst(s.curLineNum());

        s.test(nameToken);
        namedConst.name = s.curToken.id;
        s.skip(nameToken);

        // leaveParser("named const");
        return namedConst;
    }/*End parse*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(name);
    }/*End prettyPrint*/

    @Override
    public String toString(){
        return name;
    }
}/*End class*/
