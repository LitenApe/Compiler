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

  /**
   * For each line that is scanned and registered as a comment, this method
   * parses the comment until the end of comment, so that tokens are not generated.
   */
  private void scanComment(){
      if(sourceLine.endsWith("}") || sourceLine.endsWith("*/")){
          readNextLine();
      }
      else{
          readNextLine();
          sourceLine = sourceLine.replaceAll("\\s+","");
          sourceLine = sourceLine.trim();
          scanComment();
      }
  }

  /**
   * For each line that is read by readNextLine(), there has to be a call to readNextToken() to
   * make tokens. This method checks if a line is a comment.
   */
  private void checkForComments(int inLineCommentPosition){
      if (sourceLine.startsWith("/*") || sourceLine.startsWith("{")){
          sourceLine = sourceLine.replaceAll("\\s+","");
          sourceLine = sourceLine.trim();
          scanComment();

          if(isEmptyLine()){ //Some weird thing about empty lines after comments
              readNextLine();
          }
      }else if(inLineCommentPosition != 0){
          int start = inLineCommentPosition;
          System.out.println(start);
          while(sourceLine.charAt(start) != '}'){
                    if(sourceLine.charAt(start) == '*'){
                        if(sourceLine.charAt(start+1) == '/')
                            break;
                    }
                    start++;
                }
                readNextLine();
       }
  }

  /**
   * This method returns the boolean value of an empty line
   * @return boolean expression that satisfies an empty line
   */
  private boolean isEmptyLine(){
      return sourceLine.length() == 1;
  }

  /**
   * This method returns the boolean value for a line read
   * @return boolean expression that satisfies a read line
   */
  private boolean finishedReading(){
      return sourceLine.length()-1 <= sourcePos;
  }


  public void readNextToken() {
    curToken = nextToken;  nextToken = null;

    //Part 1 of INF 2100
    buf = ""; //Resets the buffer

    if(finishedReading()){
        buf="";
        readNextLine();
    }//Checks if line is read, resets buffer and reads next line
    if(isEmptyLine()){
        buf="";
        readNextLine();
    }//Checks if line is empty, resets buffer and reads next line

    checkForComments(0); //TODO: FIX if comment comes on same line as token

    int lineNum = getFileLineNum();
    if(sourceLine.equals("")){
        nextToken = new Token(eofToken,lineNum);
    }//Checks if the line is empty, thus indicating end of file
    else{
        for(int i = sourcePos; i < sourceLine.length(); i++){
            char lineChar = sourceLine.charAt(i);

            //Check for inline comments
            if(lineChar == '{'){
                checkForComments(sourcePos);
                continue;
            }
            else if(lineChar == '/'){
                if (sourceLine.charAt(i+1) == '*')
                    checkForComments(sourcePos);
                    continue;
            }

            if(lineChar == ' '){
                if(buf.length() == 0){
                    sourcePos+=1;
                    continue;
                }//Checks for excessive space (indent and space after lines)
                sourcePos+=1;
                break;
            }//Everything read up until the empty char is a token
            else if (isLetterAZ(lineChar) || isDigit(lineChar)){
                if(isLetterAZ(lineChar) && isDigit(sourceLine.charAt(i+1))){ //TODO: CHeck v1 and potentially other variables of size > 2
                    buf += lineChar;
                    buf += sourceLine.charAt(i+1);
                    sourcePos+=2;
                    break;
                }
                else{
                    buf += lineChar;
                    sourcePos+=1;
                }
                continue;
            }
            else{ //special character
                boolean sourcePosIncrementedMoreThanOne = false;
                if(buf.length() > 0){
                    break;
                }
                else{
                    //TODO: CHeck double/presedence cases
                    char nextChar = sourceLine.charAt(i+1);

                    switch(lineChar){
                        case '+': nextToken = new Token(addToken,lineNum);break;
                        case '*': nextToken = new Token(multiplyToken,lineNum);break;
                        case ';': nextToken = new Token(semicolonToken,lineNum);break;
                        case '-': nextToken = new Token(subtractToken,lineNum);break;
                        case ']': nextToken = new Token(rightBracketToken,lineNum);break;
                        case ')': nextToken = new Token(rightParToken,lineNum);break;
                        case '(': nextToken = new Token(leftParToken,lineNum);break;
                        case '=': nextToken = new Token(equalToken,lineNum);break;
                        case ',': nextToken = new Token(commaToken,lineNum);break;
                        case '[': nextToken = new Token(leftBracketToken,lineNum);break;
                        case ':':
                            if(nextChar == '='){
                                nextToken = new Token(assignToken,lineNum);
                                sourcePos+=2;
                                sourcePosIncrementedMoreThanOne = true;
                                break;
                            }
                            else{
                                nextToken = new Token(colonToken,lineNum); break;
                            }
                        case '.':
                            if(nextChar == '.'){
                                nextToken = new Token(rangeToken,lineNum);
                                sourcePos+=2;
                                sourcePosIncrementedMoreThanOne = true;
                                break;
                            }
                            else{
                                nextToken = new Token(dotToken,lineNum); break;
                            }
                        case '>':
                            if(nextChar == '='){
                                nextToken = new Token(greaterEqualToken,lineNum);
                                sourcePos+=2;
                                sourcePosIncrementedMoreThanOne = true;
                                break;
                            }
                            else{
                                nextToken = new Token(greaterToken,lineNum); break;
                            }
                        case '<':
                            if(nextChar == '='){
                                nextToken = new Token(lessEqualToken,lineNum);
                                sourcePos+=2;
                                sourcePosIncrementedMoreThanOne = true;
                                break;
                            }
                            else if (nextChar == '>'){
                                nextToken = new Token(notEqualToken,lineNum);
                                sourcePos+=2;
                                sourcePosIncrementedMoreThanOne = true;
                                break;
                            }
                            else{
                                nextToken = new Token(lessToken,lineNum); break;
                            }
                        case '\'':
                            nextToken = new Token(nextChar,lineNum);
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
        boolean allIsInteger = true;

        for(int i = 0; i < buf.length(); i++){
            if(!isDigit(buf.charAt(i))){
                allIsInteger = false;
                break;
            }
        }

        if(allIsInteger && buf.length() != 0){
            nextToken = new Token(Integer.parseInt(buf),lineNum);
        }else{
            nextToken = new Token(buf,lineNum);
        }
        buf="";
    }
    // System.out.println(nextToken.identify());
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
