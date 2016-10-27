package types;

import main.*;
import scanner.Scanner;
import parser.PascalSyntax;

public abstract class Type {
    public abstract String identify();

    public void checkType(Type tx, String op, PascalSyntax where, String mess) {
    	Main.log.noteTypeCheck(this, op, tx, where);
    	if (identify() != tx.identify())
    	    where.error(mess);
    }

    public static Type parse(Scanner s){
        return null;
    }

    public abstract int size();
}
