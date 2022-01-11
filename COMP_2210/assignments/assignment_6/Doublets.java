import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Kevin Bumgarner (kgb0022@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2020-04-07
 */
 
public class Doublets implements WordLadderGame {

   // A HashSet containing all valid words.
   private HashSet<String> lex;
   // A list used in getMinLadder(), cleans up code.
   private static final List<String> EMPTY_LIST = new ArrayList<String>();

   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      
      try {  
         lex = new HashSet<String>();
         Scanner s = 
            new Scanner(new BufferedReader(new InputStreamReader(in)));
            
         while (s.hasNext()) {
            String str = s.next();
            lex.add(str.toLowerCase());
            s.nextLine();
         }
         
         in.close();
      }
      
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   /////////////////////////////////////////////////////
   // IMPLEMENTATIONS FOR ALL WordLadderGame METHODS  //
   /////////////////////////////////////////////////////
   
   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   public int getHammingDistance(String str1, String str2) {
      
      if (str1.length() != str2.length()) {
         return -1;
      }
      
      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();
      
      if (str1.equals(str2)) {
         return 0;
      }
      
      int count = 0;
      int length = str1.length();
      
      for (int i = 0; i < length; i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            count++;
         }
      }
      
      return count;
   }


   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
   public List<String> getMinLadder(String start, String end) {
   
      if (start == null || end == null) {
         return EMPTY_LIST;
      }
      if (start.length() != end.length()) {
         return EMPTY_LIST;
      }   
      if (!isWord(start) || !isWord(end)) {
         return EMPTY_LIST;
      }
   
      start = start.toLowerCase();
      end = end.toLowerCase();
      List<String> ladder = new ArrayList<String>();
      
      if (start.equals(end)) {
         ladder.add(start);
         return ladder;
      }
      
      HashSet<String> visited = new HashSet<String>();
      ArrayDeque<Node> Q = new ArrayDeque<Node>();
      
      visited.add(start);
      Q.addLast(new Node(start, null));
      
      while (!Q.isEmpty()) {   
         Node nodeEval = Q.removeFirst();   
         
         for (String str : nodeEval.neighbors) {      
            
            if (!visited.contains(str)) {      
               visited.add(str);
               Q.addLast(new Node(str, nodeEval));      
               
               if (end.equals(str)) {
                  visited = new HashSet<String>();
                  Q = new ArrayDeque<Node>();
                  
                  return list(new Node(str, nodeEval));
               }
            }
         }
      }  
      
      return EMPTY_LIST;
   }
   
   
   /**
    * Returns a list of elements corresponding to a node chain.
    *
    * @param  n - a node to start the list 
    * @return list - a list created from a chain of nodes elements
    */
   private List<String> list(Node n) {
      
      List<String> list = new ArrayList<String>();
      Node eval = n;
      String str = n.element;
      
      list.add(str);
      
      while (eval.next != null) {
         str = eval.next.element;
         list.add(0, str);
         eval = eval.next;
      }
      
      return list;
   }


   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return the neighbors of the given word
    */
   public List<String> getNeighbors(String word) {
      
      word = word.toLowerCase();
      StringBuilder neighbor = new StringBuilder(word);
      List<String> neighbors = new ArrayList<String>();
      char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
         'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      
      for(int i = 0; i < word.length(); i++) {   
         neighbor = new StringBuilder(word);
         
         for (char letter: alphabet) {   
            neighbor.setCharAt(i, letter);
            
            if (isWord(neighbor.toString()) && !neighbor.toString().equals(word)) {
               neighbors.add(neighbor.toString());
            }
         }
      }
      
      return neighbors;
   }


   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   public int getWordCount() {
      return lex.size();
   }


   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return true if str is a word, false otherwise
    */
   public boolean isWord(String str) {
      return lex.contains(str.toLowerCase());
   }


   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   public boolean isWordLadder(List<String> sequence) {
   
      if (sequence == null) {
         return false;
      }
      if (sequence.size() == 0) {
         return false;
      }
      if (sequence.size() == 1 && isWord(sequence.get(0))) {
         return true;
      }
      
      String prev = null;
      
      for (String s : sequence) {
         
         if (!isWord(s)) {
            return false;
         }
         if (prev != null) {
            
            if (getHammingDistance(s, prev) != 1) {
               return false;
            }
         }
         
         prev = s; 
      }
      
      return true;
   }
   
   ///////////////////////////////////////////////////////////////////
   //                      SUB CLASSES                              //
   ///////////////////////////////////////////////////////////////////
   
   
   /** A user defined Node structure. */
   private class Node {
      // Next node in the chain.
      Node next;
      // Element Node holds.
      String element;
      // The elements neighbors, (words with hamming distance of 1 from element).
      List<String> neighbors;
   
    /**
     * Creates a new Node.
     *
     * @param elementIn - the value the new Node will hold
     * @param nextIn - a reference to the next Node in the chain
     */
      private Node(String elementIn, Node nextIn) {
         next = nextIn;
         element = elementIn;
         neighbors = getNeighbors(element);
      }
   }

}

