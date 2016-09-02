package scanner;

import main.Main;
import static scanner.TokenKind.*;

import java.io.*;

public class Scanner {
  public Token curToken = null, nextToken = null;
  private LineNumberReader sourceFile = null;
  private String sourceFileName, sourceLine = "";
  private int sourcePos = 0;

  public Scanner(String fileName) {
    sourceFileName = fileName;
    try {
      sourceFile = new LineNumberReader(new FileReader(fileName));
      readNextLine();
    } catch (FileNotFoundException e) {
      Main.error("Cannot read " + fileName + "!");
    }

    readNextToken();  readNextToken();

    //for (TokenKind k : TokenKind.values()) {
    //  System.out.println(k.toString());
    //}
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
    // Del 1 her:

    // check too see if we need to read a new line
    if(sourceLine.isEmpty() || sourcePos >= sourceLine.length()){
      while(sourceLine.isEmpty()){
        readNextLine();
      }
    }

    // remove comment if that is the current symbol
    removeComment();

    // find tokens
    String[] stringArr = sourceLine.toCharArray();

    

    while(nextToken == null){

    }

    System.out.println(nextToken.identify());
    Main.log.noteToken(nextToken);
  }

  // removes comment
  private void removeComment(){
    String cmtCheck = sourceLine.substring(sourcePos);
    if(cmtCheck.startsWith("{") || cmtCheck.startsWith("/*")){
      String symbol = cmtCheck.startsWith("{") ? "}":"*/";
      if(cmtCheck.endsWith(symbol)){
        readNextLine();
      }else{  // multiline comment
        while(!cmtCheck.contains(symbol)){
          readNextLine();
        }
        if(cmtCheck.endsWith(symbol)){
          readNextLine();
        }else{
          sourcePos = sourceLine.indexOf(symbol) + symbol.length();
        }
        // a second check to se if there is another comment
        removeComment();
      }
    }
  }

  private void readNextLine() {
    if (sourceFile != null) {
      try {
        sourceLine = sourceFile.readLine();
        if (sourceLine == null) {
          sourceFile.close();  sourceFile = null;
          sourceLine = "";
        } else {
          sourceLine += " ";
          sourceLine = sourceLine.toLowerCase().trim();
        }
        sourcePos = 0;
      } catch (IOException e) {
        Main.error("Scanner error: unspecified I/O error!");
      }
    }
    if (sourceFile != null)
    Main.log.noteSourceLine(getFileLineNum(), sourceLine);
  }


  private int getFileLineNum() {
    return (sourceFile!=null ? sourceFile.getLineNumber() : 0);
  }


  // Character test utilities:

  private boolean isLetterAZ(char c) {
    return 'A'<=c && c<='Z' || 'a'<=c && c<='z';
  }


  private boolean isDigit(char c) {
    return '0'<=c && c<='9';
  }


  // Parser tests:

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
