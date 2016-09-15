package scanner;

import main.Main;
import static scanner.TokenKind.*;

import java.io.*;
import java.util.*;

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
      readNextLine();
      while(sourceLine.isEmpty() && getFileLineNum() != -1){
        readNextLine();
      }
    }

    // remove comment if that is the current symbol
    removeComment();

    if(sourceLine.isEmpty() || sourcePos >= sourceLine.length()){
      readNextLine();
      while(sourceLine.isEmpty() && getFileLineNum() != -1){
        readNextLine();
      }
    }

    // find tokens
    char[] charArr = sourceLine.toCharArray();

    if(sourceFile == null){
      nextToken = new Token(eofToken,getFileLineNum());
    }

    while(nextToken == null){
      while((charArr[sourcePos] == ' ' || charArr[sourcePos] == '\t') && sourcePos < sourceLine.length()){
        sourcePos++;
      }

      if(isLetterAZ(charArr[sourcePos])){
        for(;sourcePos <= charArr.length - 1; sourcePos++){
          if(isLetterAZ(charArr[sourcePos]) || isDigit(charArr[sourcePos])){
            newToken += charArr[sourcePos];
          }else{
            nextToken = new Token(newToken,getFileLineNum()); break;
          }
        }
        nextToken = new Token(newToken,getFileLineNum());
      }else if(isDigit(charArr[sourcePos])){
        while(sourcePos < sourceLine.length() && isDigit(charArr[sourcePos])){
          newToken += charArr[sourcePos++];
        }
        nextToken = new Token(Integer.parseInt(newToken),getFileLineNum());
      }else{  // special character
        if(sourcePos + 1 < charArr.length && (charArr[sourcePos] == ':' || charArr[sourcePos] == '>' || charArr[sourcePos] == '<' || charArr[sourcePos] == '.') && (charArr[sourcePos + 1] == '=' || charArr[sourcePos] == '.' || charArr[sourcePos] == '>')){
          newToken+=charArr[sourcePos];
          newToken+=charArr[++sourcePos];
          switch(newToken){
            case ":=" : nextToken = new Token(assignToken,getFileLineNum()); break;
            case ">=" : nextToken = new Token(greaterEqualToken,getFileLineNum()); break;
            case "<=" : nextToken = new Token(lessEqualToken,getFileLineNum()); break;
            case "<>" : nextToken = new Token(notEqualToken,getFileLineNum()); break;
            case ".." : nextToken = new Token(rangeToken,getFileLineNum()); break;
            default: break;
          }
        }else{
          switch(charArr[sourcePos]){
            case '+' : nextToken = new Token(addToken,getFileLineNum()); break;
            case ':' : nextToken = new Token(colonToken,getFileLineNum()); break;
            case ',' : nextToken = new Token(commaToken,getFileLineNum()); break;
            case '/' : nextToken = new Token(divideToken,getFileLineNum()); break;
            case '.' : nextToken = new Token(dotToken,getFileLineNum()); break;
            case '=' : nextToken = new Token(equalToken,getFileLineNum()); break;
            case '>' : nextToken = new Token(greaterToken,getFileLineNum()); break;
            case '[' : nextToken = new Token(leftBracketToken,getFileLineNum()); break;
            case '(' : nextToken = new Token(leftParToken,getFileLineNum()); break;
            case '<' : nextToken = new Token(lessToken,getFileLineNum()); break;
            case '*' : nextToken = new Token(multiplyToken,getFileLineNum()); break;
            case ']' : nextToken = new Token(rightBracketToken,getFileLineNum()); break;
            case ')' : nextToken = new Token(rightParToken,getFileLineNum()); break;
            case ';' : nextToken = new Token(semicolonToken,getFileLineNum()); break;
            case '-' : nextToken = new Token(subtractToken,getFileLineNum()); break;
            case '^' : nextToken = new Token(upArrowToken,getFileLineNum()); break;
            case '\'': nextToken = new Token(charArr[sourcePos+1],getFileLineNum());
                                   sourcePos = sourcePos + 2;
                                   break;
            default: break;
          }
        }
        if(nextToken != null){
          sourcePos++;
        }
      }
      if(nextToken == null) newToken += charArr[sourcePos];
    }

    System.out.println(nextToken.identify());
    Main.log.noteToken(nextToken);
  }

  // removes comment
  private void removeComment(){
    String cmtCheck = sourceLine.substring(sourcePos).trim();
    if(cmtCheck.startsWith("{") || cmtCheck.startsWith("/*")){
      String symbol = cmtCheck.startsWith("{") ? "}":"*/";
      if(cmtCheck.endsWith(symbol)){
        readNextLine();
      }else{  // multiline comment
        while(!cmtCheck.contains(symbol)){
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
        sourceLine = sourceFile.readLine();
        if (sourceLine == null) {
          sourceFile.close();  sourceFile = null;
          sourceLine = "";
        } else {
          sourceLine += " ";
          sourceLine = sourceLine.toLowerCase().trim();
          System.out.println("READ: " + sourceLine);
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
    return (sourceFile!=null ? sourceFile.getLineNumber() : -1);
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
