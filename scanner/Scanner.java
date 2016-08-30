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


    //Finished reading line
    if(sourceLine.length() == sourcePos){
        System.out.println("Finished reading line");
        sourcePos = 0;
        readNextLine();
    }

    //Check if line is empty
    if(sourceLine.equals("") || sourceLine.length() == 0){
        nextToken = new Token(eofToken,getFileLineNum());
        System.out.println("line is empty");
        sourcePos = 0;
        readNextLine();
    }

    //Read and scan line
    String token = "";
    for(int i = sourcePos; i < sourceLine.length(); i++){
        char tokenChar = sourceLine.charAt(i);

        //If space, one token
        if(tokenChar == ' '){
            nextToken = new Token(token,getFileLineNum());
            System.out.println("Token space: " + token);
            token="";
            sourcePos+=1;
            break;
        }
        else if (isLetterAZ(tokenChar) || isDigit(tokenChar)){
            token+=tokenChar;
            System.out.println("Token cat: " + token);
            sourcePos+=1;
            specialCharIsPartOfToken = true;
            continue; //Continue to read
        }
        else{
            if(specialCharIsPartOfToken){ //&& isNotComment()
                System.out.println("PART OF TOKEN bef: " + token);
                nextToken = new Token(token,getFileLineNum());
                token="";
                token+="" + tokenChar;
                System.out.println("PART OF TOKEN af: " + token);
                nextToken = new Token(token,getFileLineNum());
                token="";
                sourcePos+=1;
                specialCharIsPartOfToken = false;
            }
            else{

                //sourceLine = sourceLine.trim();
                //System.out.println(sourceLine);

                //boolean isCommentStart = sourceLine.startsWith("/*") || sourceLine.startsWith("{");
                //boolean isCommentEnd = sourceLine.endsWith("*/") || sourceLine.endsWith("}");
                //if(isCommentStart && isCommentEnd){ //Single Line
                //    readNextLine();
                //}

            }
        }//Special character
    }//end for loop

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
