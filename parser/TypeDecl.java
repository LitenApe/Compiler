package parser;

import main.Main;

class TypeDecl extends PascalDecl{
    public TypeDecl(String id,int lNum){
        super(id, lNum);

        switch(id){
            case "integer":
                type = Library.integerType;
                break;
            case "boolean":
                type = Library.booleanType;
                break;
            case "char":
                type = Library.characterType;
                break;
            default:
                break;
        }
    }/*End of constructor*/

    @Override
    public String identify() {
        return "<type decl> " + name + " in the library";
    } /* End of identify */

    @Override
    public void checkWhetherAssignable(PascalSyntax where){

    }/*End checkWhetherAssignable*/

    @Override
    public void checkWhetherFunction(PascalSyntax where){

    }/*End checkWhetherFunction*/

    @Override
    public void checkWhetherProcedure(PascalSyntax where){

    }/*End checkWhetherProcedure*/

    @Override
    public void checkWhetherValue(PascalSyntax where){

    }/*End checkWhetherValue*/
}
