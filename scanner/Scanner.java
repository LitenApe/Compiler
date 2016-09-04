package scanner;

import main.Main;
import static scanner.TokenKind.*;

import java.io.*;

public class Scanner {
  public Token curToken = null, nextToken = null;

  private LineNumberReader sourceFile = null;
  private String sourceFileName, sourceLine = "";
  private int sourcePos = 0;

  private String buf;
  private boolean commentIsScanned = false;
  private boolean stillInComment = false;

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

  /*Single comment works*/
  private void scanComment(){
    //   System.out.println("START SCANNING !!!!!! _____----- " + sourceLine);
      if(sourceLine.endsWith("}") || sourceLine.endsWith("*/")){
          readNextLine();
      }
      else{
          System.out.println("STILLL comment !!!!! --- " + sourceLine);
          readNextLine();
          sourceLine = sourceLine.replaceAll("\\s+","");
          sourceLine = sourceLine.trim();
          System.out.println("after NEW read ------- " + sourceLine);
          scanComment();
      }
  }

  private void checkForComments(){
      if (sourceLine.startsWith("/*") || sourceLine.startsWith("{")){
          sourceLine = sourceLine.replaceAll("\\s+","");
          sourceLine = sourceLine.trim();
          scanComment();

          if(isEmptyLine()){ //Some weird thing about empty lines after comments
              readNextLine();
          }
      }
  }
  private boolean isEmptyLine(){
      return sourceLine.length() == 1;
  }
  private boolean finishedReading(){
      return sourceLine.length()-1 <= sourcePos;
  }

  public void readNextToken() {
    curToken = nextToken;  nextToken = null;

    // Del 1 her:

    buf = ""; //Reset buffer

    if(finishedReading()){
        buf="";
        readNextLine();
    }
    if(isEmptyLine()){
        buf="";
        readNextLine();
    }

    checkForComments();

    int lineNum = getFileLineNum();
    if(sourceLine.equals("")){
        // System.out.println("LNUM eof" + lineNum);
        nextToken = new Token(eofToken,lineNum);
    }
    else{
        for(int i = sourcePos; i < sourceLine.length(); i++){
            //System.out.println("sourceLine: " + sourceLine);
            char lineChar = sourceLine.charAt(i);
            // System.out.println("lineChar: " + lineChar);
            // System.out.println("sourcepos: " + sourcePos);

            //Everything read up until space is a token
            // System.out.println(sourceLine);

            if(lineChar == ' '){
                if(buf.length() == 0){
                    sourcePos+=1;
                    continue;
                }
                sourcePos+=1;
                break;
            }else if (isLetterAZ(lineChar)){
                if(isLetterAZ(lineChar) && isDigit(sourceLine.charAt(i+1))){ //TODO: CHeck v1 and commenting
                    buf += lineChar;
                }else{
                    buf += lineChar;
                }
                // System.out.println("BUFFER: " + buf);
                //System.out.println("buf isL or isD: " + buf);
                sourcePos+=1;
                continue;
            }else if(isDigit(lineChar)){
                nextToken = new Token(intValToken,lineNum);
                sourcePos+=1;
                break;
            }
            else{ //special character
                boolean sourcePosIncrementedMoreThanOne = false;
                if(buf.length() > 0){
                    break;
                }
                else{
                    switch(lineChar){
                        case '+': nextToken = new Token(addToken,lineNum); break;
                        case ':':
                                nextToken = new Token(colonToken,lineNum); break;
                        case ',': nextToken = new Token(commaToken,lineNum); break;
                        case '.':
                                nextToken = new Token(dotToken,lineNum); break;
                        case '=': nextToken = new Token(equalToken,lineNum); break;
                        case '>':
                                nextToken = new Token(greaterToken,lineNum); break;
                        case '[': nextToken = new Token(leftBracketToken,lineNum); break;
                        case '<':
                            nextToken = new Token(lessToken,lineNum); break;
                        case '*': nextToken = new Token(multiplyToken,lineNum); break;
                        case ';':
                            nextToken = new Token(semicolonToken,lineNum); break;
                        case '-': nextToken = new Token(subtractToken,lineNum); break;
                        case ']': nextToken = new Token(rightBracketToken,lineNum); break;
                        case ')': nextToken = new Token(rightParToken,lineNum); break;
                        case '(': nextToken = new Token(leftParToken,lineNum); break;
                        case '\'':
                            nextToken = new Token(sourceLine.charAt(i+1),lineNum);
                            sourcePos+=3;
                            sourcePosIncrementedMoreThanOne = true;
                            break;
                    }//End switch
                }//End switch else
                if(!sourcePosIncrementedMoreThanOne){
                    sourcePos+=1;
                }
                break;
            }//End special character
        }//end loop
        // System.out.println("buf after loop" + buf);
    }

    if(nextToken == null){
        nextToken = new Token(buf,lineNum);
        buf="";
    }
    if (nextToken != null)
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
