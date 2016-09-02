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
  private String buf;

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


    //TODO: Create no token on empty line!!!
    // Del 1 her:
    buf = "";
    boolean tokenIsSet = false;

    if(sourceLine.length() - 1 <= sourcePos){
        System.out.println("hahahahahahahhahahahah");

        System.out.println("Finished reading: " + sourceLine);
        buf="";
        readNextLine();
    }
    if(sourceLine.length() == 1){
        System.out.println("Empty line");
        buf="";
        readNextLine();
    }
    if(sourceLine.equals("")){
        nextToken = new Token(eofToken,getFileLineNum());
        tokenIsSet = true;
    }else{
        for(int i = sourcePos; i < sourceLine.length(); i++){
            //System.out.println("sourceLine: " + sourceLine);
            char lineChar = sourceLine.charAt(i);

            System.out.println("    DEBUG: sourceline: " + sourceLine.length());
            System.out.println("    DEBUG: 1. SOURCEPOS: " + sourcePos);

            // System.out.println("lineChar: " + lineChar);
            //Everything read up until space is a token
            if(lineChar == ' '){
                if(buf.length() == 0){
                    continue;
                }
                //System.out.println("buf empty read: " + buf);
                tokenIsSet=false;
                sourcePos+=1;
                break;
            }else if (isLetterAZ(lineChar)){
                buf += lineChar;
                //System.out.println("buf isL or isD: " + buf);
                sourcePos+=1;
                continue;
            }else if(isDigit(lineChar)){
                nextToken = new Token(intValToken,getFileLineNum());
                sourcePos+=1;
                tokenIsSet = true;
                break;
            }
            else{ //special character
                tokenIsSet = true;
                if(buf.length() > 0){
                    tokenIsSet = false;
                    break;
                }
                else{
                    boolean sourcePosIncrementedMoreThanOne = false;
                    switch(lineChar){
                        case '+': nextToken = new Token(addToken,getFileLineNum()); break;
                        case ':': nextToken = new Token(":",getFileLineNum()); break;
                        case ',': nextToken = new Token(",",getFileLineNum()); break;
                        case '.': nextToken = new Token(dotToken,getFileLineNum()); break;
                        case '=': nextToken = new Token("=",getFileLineNum()); break;
                        case '>': nextToken = new Token(">",getFileLineNum()); break;
                        case '[': nextToken = new Token("[",getFileLineNum()); break;
                        case '<': nextToken = new Token("<",getFileLineNum()); break;
                        case '*': nextToken = new Token("*",getFileLineNum()); break;
                        case ';':
                            nextToken = new Token(semicolonToken,getFileLineNum());
                            break;
                        case '-': nextToken = new Token("-",getFileLineNum()); break;
                        case ']': nextToken = new Token("]",getFileLineNum()); break;
                        case ')': nextToken = new Token(rightParToken,getFileLineNum()); break;
                        case '(': nextToken = new Token(leftParToken,getFileLineNum()); break;
                        case '\'':
                            nextToken = new Token(sourceLine.charAt(i+1),getFileLineNum());
                            sourcePos+=3;
                            sourcePosIncrementedMoreThanOne = true;
                            break;
                    }//End switch
                    if(!sourcePosIncrementedMoreThanOne){
                        sourcePos+=1;
                    }
                }//End switch else
                break;
            }//End special character
        }//end loop
        // System.out.println("buf after loop" + buf);
    }

    if(!tokenIsSet){
        nextToken = new Token(buf,getFileLineNum());
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
