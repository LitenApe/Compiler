package scanner;

import main.*;
import static scanner.TokenKind.*;

import java.io.*;
import java.util.*;

public class Scanner {
    public Token curToken = null, nextToken = null;
    private LineNumberReader sourceFile = null;
    private String sourceFileName, sourceLine = "";
    private int sourcePos = 0;
    private int nrOfLines = 0,nrOfTokens = 0,nrOfChars = 0,nrOfComments=0;
    private HashMap<String, TokenKind> tokenKinds = new HashMap<>();

    public Scanner(String fileName) {
        sourceFileName = fileName;
        try {
            sourceFile = new LineNumberReader(new FileReader(fileName));
            popMap();
            readNextLine();
        } catch (FileNotFoundException e) {
            Main.error("Cannot read " + fileName + "!");
        }

        readNextToken();  readNextToken();
    }


    public String identify() {
        return "Scanner reading " + sourceFileName;
    }


    public int curLineNum() {
        return curToken.lineNum;
    }


    private void error(String message) {
        Main.error("Scanner error on " +
        (curLineNum()<0 ? "last line" : "line "+curLineNum()) +
        ": " + message);
    }


    public void readNextToken() {
        curToken = nextToken;  nextToken = null;
        String newToken = "";

        // check too see if we need to read a new line
        if(sourceLine.isEmpty() || sourcePos >= sourceLine.length()){
            readNextLine();
            while(sourceLine.isEmpty() && getFileLineNum() != -1){
                readNextLine();
            }
        }

        // remove comment if that is the current symbol
        removeComment();

        // jump over white spaces
        if(sourceLine.isEmpty() || sourcePos >= sourceLine.length()){
            readNextLine();
            while(sourceLine.isEmpty() && getFileLineNum() != -1){
                readNextLine();
            }
        }

        // convert sourceLine into an char array
        char[] charArr = sourceLine.toCharArray();

        if(sourceFile == null){
            nextToken = new Token(eofToken,getFileLineNum());
        }

        while(nextToken == null){ // jump over white spaces
            while((charArr[sourcePos] == ' ' || charArr[sourcePos] == '\t') && sourcePos < sourceLine.length()){
                sourcePos++;
            }

            if(isLetterAZ(charArr[sourcePos])){
                for(;sourcePos <= charArr.length - 1; sourcePos++){ // name tokens
                    if(isLetterAZ(charArr[sourcePos]) || isDigit(charArr[sourcePos])){
                        newToken += charArr[sourcePos];
                    }else{
                        nextToken = new Token(newToken.toLowerCase(),getFileLineNum()); break;
                    }
                }
                nextToken = new Token(newToken.toLowerCase(),getFileLineNum());
            }else if(isDigit(charArr[sourcePos])){  // int tokens
                while(sourcePos < sourceLine.length() && isDigit(charArr[sourcePos])){
                    newToken += charArr[sourcePos++];
                }
                nextToken = new Token(Integer.parseInt(newToken),getFileLineNum());
            }else{  // special character
                if(sourcePos + 1 < charArr.length && (charArr[sourcePos] == ':' || charArr[sourcePos] == '>' || charArr[sourcePos] == '<' || charArr[sourcePos] == '.') && (charArr[sourcePos + 1] == '=' || charArr[sourcePos + 1] == '.' || charArr[sourcePos + 1] == '>')){
                    newToken+=charArr[sourcePos++];
                    newToken+=charArr[sourcePos++];

                    if(tokenKinds.containsKey(newToken)){
                        nextToken = new Token(tokenKinds.get(newToken), getFileLineNum());
                    }else{
                        error("Illegal character: " + charArr[sourcePos] + "!");
                    }
                }else{
                    newToken += charArr[sourcePos++];
                    if(tokenKinds.containsKey(newToken)){
                        nextToken = new Token(tokenKinds.get(newToken), getFileLineNum());
                    }else{
                        if(newToken.equals("\'") && charArr[++sourcePos] == '\''){
                            nextToken = new Token(charArr[sourcePos-1],getFileLineNum());
                            sourcePos++;
                        }else{
                            error("Illegal character: " + charArr[sourcePos] + "!");
                        }
                    }
                }
            }
            if(nextToken == null) newToken += charArr[++sourcePos];
        }
        nrOfTokens++;
        Main.log.noteToken(nextToken);
    }

    // removes comment
    private void removeComment(){
        String cmtCheck = sourceLine.substring(sourcePos).trim();
        int commentStart = getFileLineNum();
        if(cmtCheck.startsWith("{") || cmtCheck.startsWith("/*")){
            nrOfComments++;
            String symbol = cmtCheck.startsWith("{") ? "}":"*/";
            if(cmtCheck.endsWith(symbol)){
                readNextLine();
            }else{  // multiline comment
                while(!cmtCheck.contains(symbol)){
                    if(sourceFile == null){
                        error("No end for comment starting on line " + commentStart);
                    }
                    cmtCheck=sourceLine;
                    readNextLine();
                }
                if(cmtCheck.endsWith(symbol)){
                    readNextLine();
                }else{
                    sourcePos = sourceLine.indexOf(symbol) + symbol.length();
                }
            }
        }
    }

    private void readNextLine() {
        if (sourceFile != null) {
            try {
                nrOfLines++;
                sourceLine = sourceFile.readLine();
                if (sourceLine == null) {
                    sourceFile.close();  sourceFile = null;
                    sourceLine = "";
                } else {
                    sourceLine += " ";
                    nrOfChars += sourceLine.replaceAll("\\s","").length();
                }
                sourcePos = 0;
            } catch (IOException e) {
                Main.error("Scanner error: unspecified I/O error!");
            }
        }
        if (sourceFile != null)
        Main.log.noteSourceLine(getFileLineNum(), sourceLine);
        sourceLine = sourceLine.trim();
    }

    // get the current line number in file
    private int getFileLineNum() {
        return (sourceFile!=null ? sourceFile.getLineNumber() : -1);
    }

    // populate hashmap
    private void popMap(){
        for(TokenKind tk : Arrays.asList(TokenKind.values())){
            tokenKinds.put(tk.toString() , tk);
        }
    }

    public int[] getStats(){
        int[] stats = new int[4];
        stats[0] = nrOfLines;
        stats[1] = nrOfChars;
        stats[2] = nrOfTokens;
        stats[3] = nrOfComments;
        return stats;
    }

    private boolean isLetterAZ(char c) {
        return 'A'<=c && c<='Z' || 'a'<=c && c<='z';
    }

    private boolean isDigit(char c) {
        return '0'<=c && c<='9';
    }

    public void test(TokenKind t) {
        if (curToken.kind != t)
            testError(t.toString());
    }

    public void testError(String message) {
        Main.error(curLineNum(),
        "Expected a " + message +
        " but found a " + curToken.kind + "!");
    }

    public void skip(TokenKind t) {
        test(t);
        readNextToken();
    }
}
