package parser;

import main.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Library extends Block{
    public static types.BoolType booleanType = new types.BoolType();
    public static types.CharType characterType = new types.CharType();
    public static types.IntType integerType = new types.IntType();

    // Happy ? "YES I AM :D:D:D" : "Readable name";
    public static HashMap<String, PascalDecl> procedures = new HashMap<>();   // Happy ? "YES I AM :D:D:D" : "Readable name";

    public Library(int lineNum){
        super(lineNum);
        procedures.put("true", new ConstDecl("true",0, this));
        procedures.put("false", new ConstDecl("false",0, this));
        procedures.put("write",new ProcDecl("write",0));
        procedures.put("integer",new TypeDecl("integer",0));
        procedures.put("boolean",new TypeDecl("boolean",0));
        procedures.put("char",new TypeDecl("char",0));
        procedures.put("eol",new ConstDecl("eol",0));
    }/*End of constructor*/

    @Override
    public void genCode(CodeFile f){

    }

    public PascalDecl findDecl(String id, PascalSyntax where){
        PascalDecl found = procedures.get(id);

        if (!procedures.containsKey(id))
            where.error("Name " + id + " is unknown!");
        else
            Main.log.noteBinding(id, where, found);

        return found;
    }/*End of findDecl*/

    public void addDecl(String id, PascalDecl pd){
        procedures.put(id, pd);
    }/*End of decl*/

    public PascalDecl getDecl(String id){
        return procedures.get(id);
    }/*End of getDecl*/

}/*End of class*/
