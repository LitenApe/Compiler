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

          if(sourceLine.length() == 1){ //Some weird thing about empty lines after comments
              readNextLine();
          }
      }else if(inLineCommentPosition != 0){
          int start = inLineCommentPosition;
          System.out.println(start);
          while(sourceLine.charAt(start) != '}'){
              if(sourceLine.charAt(start) == '*' &&
                  sourceLine.charAt(start+1) == '/'){
                      break;
              }
              start++;
          }
          readNextLine();
       }
  }

  public void readNextToken() {
    curToken = nextToken;  nextToken = null;

    //Part 1 of INF 2100
    buf = ""; //Resets the buffer
    if (sourceLine.length() == 1 ||
        sourceLine.length()-1 <= sourcePos ||
        sourceLine.equals("\t")){
        buf="";
        readNextLine();
    }

    checkForComments(0);

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
            else if(lineChar == '/' &&
                    sourceLine.charAt(i+1) == '*'){
                    checkForComments(sourcePos);
                    continue;
            }

            if(lineChar == ' ' || lineChar == '\t'){
                if(buf.length() == 0){
                    sourcePos+=1;
                    continue;
                }//Checks for excessive space (indent and space after lines)
                sourcePos+=1;
                break;
            }//Everything read up until the empty char is a token
            else if (isLetterAZ(lineChar) || isDigit(lineChar)){
                buf += lineChar;
                sourcePos+=1;
                continue;
            }
            else{ //special character
                if(buf.length() > 0){
                    break;
                }
                else{
                    char nextChar = sourceLine.charAt(i+1);
                    String twoCharToken = ""+lineChar;
                    twoCharToken+=nextChar;

                    for(TokenKind k : TokenKind.values()){
                        if(k.toString().equals(twoCharToken)){
                            nextToken = new Token(k,lineNum);
                            sourcePos+=2;
                            break;
                        }
                        if (k.toString().equals(""+lineChar)){
                            nextToken = new Token(k,lineNum);
                            sourcePos+=1;
                            break;
                        }
                        if(lineChar == '\''){
                            nextToken = new Token(nextChar,lineNum);
                            sourcePos+=3;
                            break;
                        }

                    }
                }//End special cases without buf build
                break;
            }//End special character
        }//end main loop
    }

    if(nextToken == null){
        try{
            nextToken = new Token(Integer.parseInt(buf),lineNum);
        }
        catch(NumberFormatException e){
            nextToken = new Token(buf.toLowerCase(),lineNum);
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
