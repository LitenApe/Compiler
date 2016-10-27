package types;

public class CharType extends Type {
    @Override
    public String identify() {
    	return "type Char";
    }

    public String toString(){
        return "character";
    }

    @Override
    public int size() {
    	return 4;
    }
}
