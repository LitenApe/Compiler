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
    if(sourceLine.equals(" ")){
      while(sourceLine.equals(" ")){
        readNextLine();
      }
    }else if(sourcePos > sourceLine.length() - 1){
      readNextLine();
    }

    // removes trailing whitespace
    if(sourceLine.length() > 1){
      sourceLine = sourceLine.trim();
    }

    // remove comment if that is the next Token
    String commentCheck = sourceLine.substring(sourcePos,sourceLine.length());
    if(commentCheck.startsWith("/*") || commentCheck.startsWith("{")){
      String symbol = commentCheck.startsWith("/*") ? "*/":"}";
      if(commentCheck.endsWith(symbol)){
        readNextLine();
      }
    }

    if(sourceFile != null){
      char[] charArr = sourceLine.toCharArray();
      for(int i = sourcePos; i < charArr.length; i++){
        if(charArr[i] == ' '){
          sourcePos++;
          break;
        }else if(charArr[i] == ';'){
          if(newToken.isEmpty()){
            nextToken = new Token(semicolonToken, getFileLineNum());
            sourcePos++;
          }
          break;
        }else if(charArr[i] == '('){
          if(newToken.isEmpty()){
            nextToken = new Token(leftParToken,getFileLineNum());
            sourcePos++;
          }
          break;
        }else if(charArr[i] == ')'){
          if(newToken.isEmpty()){
            nextToken = new Token(rightParToken, getFileLineNum());
            sourcePos++;
          }else{
            if(newToken.startsWith("'") && newToken.endsWith("'") && newToken.length() == 3){
              nextToken = new Token(charArr[i - 2],getFileLineNum());
            }
          }
          break;
        }else if(charArr[i] == '.'){
          if(newToken.isEmpty()){
            nextToken = new Token(dotToken,getFileLineNum());
            sourcePos++;
          }
          break;
        }

        newToken = newToken + charArr[i];
        sourcePos++;
      }
      if(nextToken == null){
        nextToken = new Token(newToken.toLowerCase(),getFileLineNum());
      }
    }else{
      nextToken = new Token(eofToken,getFileLineNum());
    }
    System.out.println(nextToken.identify());
    Main.log.noteToken(nextToken);
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
