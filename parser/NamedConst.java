package parser;
import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class NamedConst extends UnsignedConstant{

    public String name = "";

    public NamedConst(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("Named Const");
        // if(name.equals("integer"))
        //     super.type = lib.integerType;
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
