package parser;

import main.Main;
import java.util.HashMap;
import java.util.ArrayList;

public class Library extends Block{
    public static types.BoolType booleanType = new types.BoolType();
    public static types.CharType characterType = new types.CharType();
    public static types.IntType integerType = new types.IntType();

    // store everything that is created for this libaries scope
    // public static HashMap<String, PascalSyntax> declarations = new HashMap<>();   // Happy ? "YES I AM :D:D:D" : "Readable name";
    public static HashMap<String, PascalDecl> procedures = new HashMap<>();   // Happy ? "YES I AM :D:D:D" : "Readable name";
    public Library(int lineNum){
        super(lineNum);
        procedures.put("write",new ProcDecl("write",0));
        procedures.put("integer",new TypeDecl("integer",0));
        procedures.put("boolean",new TypeDecl("boolean",0));
        procedures.put("char",new TypeDecl("char",0));
        procedures.put("eol",new ConstDecl("eol",0));

    }/*End of constructor*/

    // @Override
    public PascalDecl findDecl(String id, PascalSyntax where){
        if (!procedures.containsKey(id))
            where.error("Name " + id + " is unknown!");
        else{
            PascalDecl found = procedures.get(id);
            Main.log.noteBinding(id,where,found);
            return found;
        }
        return null;
    }/*End of findDecl*/

}/*End of class*/
