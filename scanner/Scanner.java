package scanner;

import main.Main;
import static scanner.TokenKind.*;

import java.io.*;

public class Scanner {
  public Token curToken = null, nextToken = null;

  private LineNumberReader sourceFile = null;
  private String sourceFileName, sourceLine = "";
  private int sourcePos = 0;

  private boolean specialCharIsPartOfToken = false; //custom variable
  private boolean commentIsScanned = false;


  public Scanner(String fileName) {
    sourceFileName = fileName;
    try {
      sourceFile = new LineNumberReader(new FileReader(fileName));
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

    // Del 1 her:
    String buf = "";
    boolean tokenIsSet = false;

    if(sourceLine.length() == sourcePos){
        System.out.println("Finished reading: " + sourceLine);
        buf="";
        readNextLine();
    }
    //If file start or end
    if(sourceLine.equals("")){
        nextToken = new Token(eofToken,getFileLineNum());
        tokenIsSet = true;
    }
    else{
        for(int i = sourcePos; i < sourceLine.length(); i++){
            char lineChar = sourceLine.charAt(i);

            System.out.println("lineChar: " + lineChar);
            //Everything read up until space is a token
            if(lineChar == ' '){
                sourcePos+=1;
                break;
            }else if (isLetterAZ(lineChar) || isDigit(lineChar)){
                buf = "" + lineChar;
                sourcePos+=1;
                continue;
            }else{
                switch(lineChar){
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    case '': <> break;
                    default:
                        <>
                        break;
                }

            }
        }//end loop
    }

    if(!tokenIsSet){
        nextToken = new Token(buf,getFileLineNum());
    }
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
