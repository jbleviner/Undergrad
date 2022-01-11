import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java.util.List;
import java.util.ArrayList;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Kevin Bumgarner (kgb0022@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-04-22
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // Random Object to use when needed.
   private final Random ran = new Random();
   // A refernecre to the first kgram.
   private String firstKgram;


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    * @param K (int) - Model order.
    * @param sourceText (File) - File to analyze.
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    * @param K (int) - Model order.
    * @param sourceText (String) - text to analyze.
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    * 
    * @param K (int) - Model order.
    * @param sourceText (String) - text to analyze.
    */
   private void buildModel(int K, String sourceText) {
      
      firstKgram = sourceText.substring(0, K);
      
      for (int i = 0; i + K <= sourceText.length(); i++) {
         
         int numID = i + K;
         String key = sourceText.substring(i, numID);
                     
         if (!model.containsKey(key)) { 
            if (numID == sourceText.length()) {
               model.put(key, Character.toString('\u0000'));
            } else {
               model.put(key, Character.toString(sourceText.charAt(numID)));
            }
         } else {  
            String val = model.get(key); 
            if (numID == sourceText.length()) {
               val += Character.toString('\u0000');
            } else {
               val += sourceText.charAt(numID);
            } 
              
            model.replace(key, val);
         }
      }
   }


   /** Returns the first kgram found in the source text. 
    * 
    * @return firstKgram (String) - returns first kgram in the Model.
    */
   public String getFirstKgram() {
      assert model != null;
      return firstKgram;
   }


   /** Returns a kgram chosen at random from the source text. 
    *
    * @return (String) - returns a random key from a list.
    */
   public String getRandomKgram() {
      assert model != null;
      List<String> keys = new ArrayList<String>(model.keySet());
      
      return keys.get(ran.nextInt(keys.size()));
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    * @return keySet - returns a set of the Keys contained in the map.
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    *
    * @param kgram (String) - value associated with kgram.
    * @return (char) - returns a character that follows the given kgram.
    */
   public char getNextChar(String kgram) {
      if (model.containsKey(kgram)) {
         String s = model.get(kgram);
         return s.charAt(ran.nextInt(s.length()));
      }
      
      return '\u0000';
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    * @return (String) - returns string representation of model.
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
