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
  boolean isIncComment = false;
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
  // private void checkForComments(int inLineCommentPosition){
  //     if (sourceLine.startsWith("/*") || sourceLine.startsWith("{")){ //Single line and multiline comments
  //         sourceLine = sourceLine.replaceAll("\\s+","");
  //         sourceLine = sourceLine.trim();
  //         scanComment();
  //
  //         if(sourceLine.length() == 1){ //Some weird thing about empty lines after comments
  //             readNextLine();
  //         }
  //     }else if(inLineCommentPosition != 0){ //In line comments
  //         int start = inLineCommentPosition;
  //         System.out.println(start);
  //         while(sourceLine.charAt(start) != '}' ||
  //                   (sourceLine.charAt(start) == '*' &&
  //                       sourceLine.charAt(start+1) == '/')){
  //             start++;
  //         }
  //         readNextLine();
  //      }
  // }

  // private void remove_sourceLineStartsWithComments(){
  //     if (sourceLine.startsWith("/*") || sourceLine.startsWith("{")){ //Single line and multiline comments
  //         sourceLine = sourceLine.replaceAll("\\s+","");
  //         sourceLine = sourceLine.trim();
  //         isIncComment = true;
  //         scanComment();
  //
  //         if(sourceLine.length() == 1){ //Some weird thing about empty lines after comments
  //             readNextLine();
  //         }
  //     }
  // }
  private void checkForComments(int inLineCommentPosition){
      if (sourceLine.startsWith("/*") || sourceLine.startsWith("{")){ //Single line and multiline comments
          sourceLine = sourceLine.replaceAll("\\s+","");
          sourceLine = sourceLine.trim();
          scanComment();

          if(sourceLine.length() == 1){ //Some weird thing about empty lines after comments
              readNextLine();
          }
      }else if(inLineCommentPosition != 0){ //In line comments
          int start = 0;
          for (int i = inLineCommentPosition; sourceLine.length()-1 >= i; i++) {
              System.out.println(sourceLine.charAt(i));
              start = i;
              if(sourceLine.charAt(i) == '}'){
                start = i+1;
                break;
              }
              else if (sourceLine.charAt(i) == '*' && sourceLine.charAt(i+1) == '/'){
                start = i+2;
                break;
              }
          }
          if(sourceLine.length()-1 <= start){
              readNextLine(); //Finished reading on that line
              while(sourceLine.length() == 1){
                  readNextLine();
              }
          }
          else{
              sourcePos = start;
          }
       }
  }

  public void readNextToken() {
    curToken = nextToken;  nextToken = null;

    //Part 1 of INF 2100
    buf = ""; //Resets the buffer
    if (sourceLine.length() == 1 ||
        sourceLine.length()-1 <= sourcePos){
        buf="";
        readNextLine();
    }

    // checkForComments(0);

    int lineNum = getFileLineNum();
    if(sourceLine.equals("")){
        nextToken = new Token(eofToken,lineNum);
    }//Checks if the line is empty, thus indicating end of file
    else{
        checkForComments(0);
        for(int i = sourcePos; i < sourceLine.length(); i++){
            char lineChar = sourceLine.charAt(i);

            if(lineChar == '{' ||
                (lineChar == '/' &&
                    sourceLine.charAt(i+1) == '*')){
                System.out.println(sourcePos+" <<< SP Started comment inline: " +sourceLine.charAt(i));
                checkForComments(sourcePos);
                System.out.println(sourcePos + " Should be changed");
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
                        //Presedence case, check "to char tokens" first, :=,<> etc
                        if(k.toString().equals(twoCharToken)){
                            nextToken = new Token(k,lineNum);
                            sourcePos+=2;
                            break;
                        }
                        //Otherwise check special chars such as >,<,= etc
                        if (k.toString().equals(""+lineChar)){
                            nextToken = new Token(k,lineNum);
                            sourcePos+=1;
                            break;
                        }
                        //Special case for char tokens
                        if(lineChar == '\''){
                            nextToken = new Token(nextChar,lineNum);
                            sourcePos+=3;
                            break;
                        }
                    }
                    break;
                }//End special cases without buf build
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
