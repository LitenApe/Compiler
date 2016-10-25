package parser;

import main.Main;
import java.util.HashMap;
import java.util.ArrayList;

public class Library extends Block{

    // store everything that is created for this libaries scope
    HashMap<String, PascalDecl> declarations = new HashMap<>();   // Happy? readable name

    public Library(int lineNum){
        super(lineNum);
    }/*End of constructor*/

    public void addDeclarations(ArrayList<ConstDecl> decls){
        for(PascalDecl d : decls){
            String name = d.toString();  // this variable is for readability.

            if(declarations.containsKey(name))
                Main.error(name + " is declared twice in the same block");

            declarations.put(name, d);
        }
    }/*End of addConstants*/

    public PascalDecl findDeclarations(String name){
        return  declarations.get(name);
    }/*End of findDeclarations*/
}/*End of class*/
