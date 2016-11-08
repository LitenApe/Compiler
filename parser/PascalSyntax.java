package parser;

import main.*;
import scanner.*;

public abstract class PascalSyntax {
    public int lineNum;

    PascalSyntax(int n) {
       lineNum = n;
    }

    boolean isInLibrary() {
	return lineNum < 0;
    }

    abstract public String identify(); //del 2
    abstract public void prettyPrint(); //del 2
    abstract public void check(Block curScope, Library lib); //del 3
    abstract public void genCode(CodeFile f);   // del 4

    public void error(String message) {
	Main.error("Error at line " + lineNum + ": " + message);
    }

    static void enterParser(String nonTerm) {
	Main.log.enterParser(nonTerm);
    }

    static void leaveParser(String nonTerm) {
	Main.log.leaveParser(nonTerm);
    }
}
