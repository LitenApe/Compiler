package types;

public class CharType extends Type {
    @Override
    public String identify() {
    	return "type Character";
    }

    @Override
    public String writeCMD(){
        return "write_char";
    }

    public String toString(){
        return "character";
    }

    @Override
    public int size() {
    	return 4;
    }
}
