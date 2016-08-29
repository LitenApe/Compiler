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

    // leser en hel linjen
    if(sourceLine.isEmpty() || sourcePos >= sourceLine.length() - 2){
       readNextLine();
       sourcePos = 0;
     }

    // sjekker etter kommentar
    removeComments();

    // henter forste token
    char[] lineArray = sourceLine.toCharArray();
    String newToken = "";

    while(true){
      if(sourcePos >= sourceLine.length()){
        break;
      }else if(lineArray[sourcePos] == ' ' && newToken.isEmpty()){
        sourcePos++;
      }else if(lineArray[sourcePos] == ' ' || sourcePos == sourceLine.length() - 1 || lineArray[sourcePos] == ';'){
        if(lineArray[sourcePos] != ';') sourcePos++;
        break;
      }
      newToken = newToken + lineArray[sourcePos];
      sourcePos++;
    }

    newToken = newToken.trim().toLowerCase();

    // System.out.println(newToken);

    if(sourceLine.isEmpty())
      nextToken = new Token(eofToken,getFileLineNum());
    else if(!newToken.equals(""))
      nextToken = new Token(newToken,getFileLineNum());

    Main.log.noteToken(nextToken);
  }

  // remove comments from the line { ... } or /* ... */
  private void removeComments(){
    boolean startBracket = sourceLine.startsWith("{");
    boolean endBracket = sourceLine.endsWith("}");
    boolean startAstCom = sourceLine.startsWith("/*");
    boolean endAstCom = sourceLine.endsWith("*/");
    int sourceLength = sourceLine.length();

    // System.out.println(sourceLine);

    if(startBracket){
      if(endBracket){ // hele linjen er en kommentar
        readRemove();
      }else{  // move the pointer to the end of the comment
        sourcePos = sourceLine.indexOf("}") + 2;
        if (sourcePos >= sourceLength){
          readRemove();
        }
      }
    }else if(startAstCom){
      if(endAstCom){ // hele linjen er en kommentar
        readRemove();
      }else{  // move the pointer to the end of the comment
        sourcePos = sourceLine.indexOf("*/") + 3;
        if (sourcePos >= sourceLength){
          readRemove();
        }
      }
    }
  }

  // hjelper metode for å starte en 'rekursiv' prosess
  private void readRemove(){
    readNextLine();
    removeComments();
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
