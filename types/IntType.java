package types;

public class IntType extends Type {
    @Override
    public String identify() {
    	return "type Integer";
    }

    @Override
    public String writeCMD(){
        return "write_int";
    }

    public String toString(){
        return "integer";
    }

    @Override
    public int size() {
    	return 4;
    }
}
