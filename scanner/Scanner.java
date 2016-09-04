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
  private String buf;
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

  private int scanComment(String sl){

    //   System.out.println("before check" + sl);
      if(sl.endsWith("}") || sl.endsWith("*/")){
          commentIsScanned = true;
        //   System.out.println("in check" + sl);
          return 0;
      }
      else{
        //   System.out.println("before read" + sl);
          readNextLine();
        //   System.out.println("after read" + sl);
          sl = sourceLine.replaceAll("\\s+","");
          sl = sourceLine.trim();
          scanComment(sl);
          readNextLine();
      }

      return 0;
  }


  /*TODO: Finish this method*/
  public void readNextToken() {
    curToken = nextToken;  nextToken = null;

    // Del 1 her:
    buf = "";
    if(sourceLine.length()-1 <= sourcePos){
        // System.out.println("Finished reading: " + sourceLine);
        buf="";
        readNextLine();
    }
    if(sourceLine.length() == 1){
        // System.out.println("Empty line");
        buf="";
        readNextLine();
    }

    int lineNum = getFileLineNum();
    if(sourceLine.equals("")){
        nextToken = new Token(eofToken,getFileLineNum());
    }else{
        if(sourceLine.startsWith("/*") || sourceLine.startsWith("{")){ //CHeck if comment //TODO: DOESN WORKT
            // commentIsScanned();s
                readNextLine();
                // System.out.println("before replacing" + sourceLine);
                sourceLine = sourceLine.replaceAll("\\s+","");
                // System.out.println("after replacing before trimming" + sourceLine);
                sourceLine = sourceLine.trim();
                // System.out.println("after replacing after trimming" + sourceLine);
                scanComment(sourceLine);
        }

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
                System.out.println("BUFFER: " + buf);
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
