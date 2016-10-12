package parser;
import scanner.Scanner;
import static scanner.TokenKind.*;
import main.Main;

public class NamedConst extends UnsignedConstant{

    String name = "";
    public NamedConst(int n){
        super(n);
    }/*End constructor*/

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
}/*End class*/
