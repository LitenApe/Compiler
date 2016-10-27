package types;

public class BoolType extends Type {
    @Override public String identify() {
    	return "type Boolean";
    }

    public String toString(){
        return "boolean";
    }

    @Override public int size() {
    	return 4;
    }
}
