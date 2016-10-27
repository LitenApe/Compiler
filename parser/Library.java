package parser;

import main.Main;
import java.util.HashMap;
import java.util.ArrayList;

public class Library extends Block{

    // store everything that is created for this libaries scope
    // public static HashMap<String, PascalSyntax> declarations = new HashMap<>();   // Happy ? "YES I AM :D:D:D" : "Readable name";
    public static ProcCallStatm write = null;
    // public static HashMap<String, PascalDecl> procedures = new HashMap<>();   // Happy ? "YES I AM :D:D:D" : "Readable name";

    public Library(int lineNum){
        super(lineNum);
    }/*End of constructor*/

    // @Override
    public PascalDecl findDecl(String id, PascalSyntax where){
        System.out.println("2. MADYAR: AKE: "+id);
        // PascalDecl found = procedures.get(id);

        PascalDecl found = new ProcDecl(id,0);
        if (found != null)
            // Main.log.noteBinding(id,where,found);

        if(found == null)
            where.error("Name " + id + " is unknown!");

        return found;
    }/*End of findDecl*/

}/*End of class*/
