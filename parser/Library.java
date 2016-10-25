package parser;

import main.Main;
import java.util.HashMap;
import java.util.ArrayList;

public class Library extends Block{

    // store everything that is created for this libaries scope
    public static HashMap<String, PascalDecl> declarations = null;   // Happy ? "YES I AM :D:D:D" : "Readable name";

    public Library(int lineNum){
        super(lineNum);
        declarations = new HashMap<>();
    }/*End of constructor*/

    @Override
    public PascalDecl findDecl(String id, PascalSyntax where){
        System.out.println("2. MADYAR: AKE: "+id);
        PascalDecl found = declarations.get(id);
        if (found != null){
            Main.log.noteBinding(id,where,found);
            return found;
        }
        where.error("Name " + id + " is unknown!");
        return null;
    }

    // public void addDecl(PascalDecl decls){
    //     String name = decls.toString();  // this variable is for readability.
    //
    //     if(declarations.containsKey(name))
    //         Main.error(name + " is declared twice in the same block");
    //
    //     declarations.put(name, decls);
    // }/*End of addConstants*/

    // public PascalDecl findDecl(String name){
    //     return declarations.get(name);
    // }/*End of findDeclarations*/
}/*End of class*/
