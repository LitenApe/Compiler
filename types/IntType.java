package types;

public class IntType extends Type {
    @Override
    public String identify() {
    	return "type Integer";
    }

    public String toString(){
        return "integer";
    }

    @Override
    public int size() {
    	return 4;
    }
}
