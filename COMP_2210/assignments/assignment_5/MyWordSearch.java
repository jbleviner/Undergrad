import java.util.List;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class implementation of the WordSearchGame interface.
 *
 * Plays the game of Boggle.
 *
 * @author Kevin Bumgarner (kgb0022@auburn.edu)
 * @version 03-28-20
 */


public class MyWordSearch implements WordSearchGame {
   // ----------------------- FIELDS ---------------------------//
   
   // TreeSet holding all valid words.
   private TreeSet<String> lexicon;
   // TreeSet holding all valid words from current board.
   private TreeSet<String> globalWords;
   // 2d representation of the game board.
   private String[][] gameBoard;
   // 2d representation of 'visited' letters on the game board.
   private boolean[][] visited;
   // Stores 'Path' for isOnBoard() method.
   private List<Integer> globalPath;
   // Square root of the game boards rows X columns.
   private int size;
   // Number of Rows on the game board.
   private int numRows;
   // Number of columns on the game board.
   private int numCols;
  
   //----------------------- CONSTRUCTOR -----------------------//
   public MyWordSearch() {
      lexicon = null;
      
      size = 4;
      numRows = 4;
      numCols = 4;
      
      visited = new boolean[numRows][numCols];
      globalPath = new ArrayList<Integer>();
      globalWords = new TreeSet<String>();
      
      gameBoard = new String[size][size];
      gameBoard[0][0] = "E"; 
      gameBoard[0][1] = "E"; 
      gameBoard[0][2] = "C"; 
      gameBoard[0][3] = "A"; 
      gameBoard[1][0] = "A"; 
      gameBoard[1][1] = "L"; 
      gameBoard[1][2] = "E"; 
      gameBoard[1][3] = "P"; 
      gameBoard[2][0] = "H"; 
      gameBoard[2][1] = "N"; 
      gameBoard[2][2] = "B"; 
      gameBoard[2][3] = "O"; 
      gameBoard[3][0] = "Q"; 
      gameBoard[3][1] = "T"; 
      gameBoard[3][2] = "T"; 
      gameBoard[3][3] = "Y";
   }
   
  //------------------- METHODS ---------------------------//
  
   
   /**
    * Loads the lexicon into a TreeSet. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
    
      if (fileName == null) {
         throw new IllegalArgumentException();
      }
      
      lexicon = new TreeSet<String>();  
      try {
         File file = new File(fileName);
         Scanner s = new Scanner(file);
         while (s.hasNext()) {
            String word = s.next().toUpperCase();
            lexicon.add(word);
         }
         s.close();   
      } catch (FileNotFoundException e) {
         throw new IllegalArgumentException();
      }
   }
   
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */
   public void setBoard(String[] letterArray) {
      if (letterArray == null) {
         throw new IllegalArgumentException();
      }
      
      double n = Math.sqrt(letterArray.length);
      
      if (n % 1 > 0) {
         throw new IllegalArgumentException();
      }
      
      int k = 0;
      gameBoard = new String[(int) n][(int) n];
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            String value = letterArray[k].toUpperCase();
            gameBoard[i][j] = value;
            k++;
         }
      }
      
      size = (int) n;
      numRows = (int) n;
      numCols = (int) n;
      visited = new boolean[numRows][numCols];
   }
   
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
      String str = "";
      int s = size;
      
      for (int i = 0; i < s; i++) {
         str += "\n";
         for (int j = 0; j < s; j++) {
            str += "[" + gameBoard[i][j] + "] ";
         }
      }
      
      return str + "\n";
   }
   
   
   /**
    * Retrieves all valid words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.TreeSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      
      allClear(); 
   
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      
      TreeSet<String> allWords = new TreeSet<String>();
      allClear(); 
      String wordSoFar = ""; 
   
      for (int i = 0; i < numRows; i++) { 
         for (int j = 0; j < numCols; j++) { 
            dfsAll(i, j, minimumWordLength, wordSoFar); 
         }
      }
      
      allWords = globalWords;
      globalWords = new TreeSet<String>();
      
      return allWords;
   }
   
   
   /** Method to mark every position on the board as un-visited. */
   private void allClear() {
      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numCols; j++) {
            visited[i][j] = false;
         }
      }
   }
   
   
   /**
    * Depth First Search method to find all words on a Boggle board.
    *
    * @param i (int) - Row index on game board.
    * @param j (int) - Column index on game board.
    * @param min (int) - minimum word length of valid words on board.
    * @param wordSoFar (StringBuilder) - possibble word to be found.
    */
   private void dfsAll(int i, int j, int min, String wordSoFar) {
   
      if (i >= numRows || i < 0 || j < 0 || j >= numCols) {
         return;
      }     
      if (visited[i][j] == true) {
         return;
      }
      if (!(isValidPrefix(wordSoFar.toString() + gameBoard[i][j]))) {
         return;
      } 
    
      visited[i][j] = true; 
      wordSoFar = wordSoFar + gameBoard[i][j]; 
   
      if (isValidWord(wordSoFar) && wordSoFar.length() >= min)  {
         globalWords.add(wordSoFar);
      } 
   
      for (int k = i - 1; k <= i + 1; k++) {
         for (int l = j - 1; l <= j + 1; l++) {
            dfsAll(k, l, min, wordSoFar);
         }
      } 
   
      visited[i][j] = false;
      wordSoFar = "" + wordSoFar.charAt(wordSoFar.length() - 1); 
   }
   
   
  /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      
      int score = 0;
      String targetWord = "";
      Iterator<String> itr = words.iterator();
      
      while (itr.hasNext()) {
         targetWord = itr.next();
         if (targetWord.length() >= minimumWordLength && isValidWord(targetWord)
         && !isOnBoard(targetWord).isEmpty()) {
            score += (targetWord.length() - minimumWordLength) + 1; 
         }
      }
      
      return score;
   }
   
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      String upperWordToCheck = wordToCheck.toUpperCase();
      return lexicon.contains(upperWordToCheck);
   }
   
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck) {
      if (prefixToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      String upperPTC = prefixToCheck.toUpperCase();
      String match = lexicon.ceiling(upperPTC);
      if (match != null) {
         return match.startsWith(upperPTC);
      }
      return false; 
   }
    
      
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
   
      visited = new boolean[numRows][numCols]; 
   
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      
      wordToCheck = wordToCheck.toUpperCase();
      List<Integer> path = new ArrayList<Integer>();
      StringBuilder wordSoFar = new StringBuilder();
      
      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numCols; j++) {
            if (wordToCheck.equals(gameBoard[i][j])) {
               path.add((i * numRows) + j);
               return path;
            }
            if (wordToCheck.startsWith(gameBoard[i][j])) {
               if (DFS(i, j, wordToCheck, wordSoFar, path)) {
                  path = getPath();
               }
            }
         }
      }
      
      globalPath = new ArrayList<Integer>();
      visited = new boolean[numRows][numCols]; 
      
      return path;
   }
   
   
   /** Method to get word position. */
   private List<Integer> getPath() {
      return globalPath;
   }
   
   /**
    * Depth First Search Method for Boggle Board. 
    * Method to find a single word on the game board.
    *
    * @param i (int) - row index on game board.
    * @param j (int) - column index on game board.
    * @param wordToCheck (String) - a word to find on game board.
    * @param wordSoFar (String) - a word sequence.
    * @param path (List<Integer>) - position of wordToCheck on game baord.
    *
    * @return true - returns true if word is on board.
    */
   private boolean DFS(int i, int j, String wordToCheck, StringBuilder wordSoFar, List<Integer> path){
     
      if (i >= numRows || i < 0 || j < 0 || j >= numCols) {
         return false;
      }     
      if (visited[i][j] == true) {
         return false;
      }     
      if (!wordToCheck.startsWith(wordSoFar.toString() + gameBoard[i][j])) {
         return false;
      }
      
      visited[i][j] = true; 
      wordSoFar.append(gameBoard[i][j]);
      path.add((i * size) + j);
      
      if (wordSoFar.toString().equals(wordToCheck)) {
         return true;
      }
        
      for (int k = i - 1; k <= i + 1; k++) {
         for (int l = j - 1; l <= j + 1; l++) {
            if (DFS(k, l, wordToCheck, wordSoFar, path)) {
               globalPath = path;
               return true;
            }
         }
      }
      
      visited[i][j] = false;
      wordSoFar.deleteCharAt(wordSoFar.length() - 1);
      path.remove(path.size() - 1);
      
      return false;
   }  
}