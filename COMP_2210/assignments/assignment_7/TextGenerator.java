import java.io.File;
import java.io.IOException;

/**
 * TextGenerator.java. Creates an order K Markov model of the supplied source
 * text, and then outputs M characters generated according to the model.
 *
 * @author     Kevin Bumgarner (kgb0022@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-04-21
 *
 */
public class TextGenerator {

   /** Drives execution. */
   public static void main(String[] args) {
   
      if (args.length < 3) {
         System.out.println("Usage: java TextGenerator k length input");
         return;
      }
   
      // No error checking! You may want some, but it's not necessary.
      int K = Integer.parseInt(args[0]);
      int M = Integer.parseInt(args[1]);
      if ((K < 0) || (M < 0)) {
         System.out.println("Error: Both K and M must be non-negative.");
         return;
      }
   
      //File text;
      String text;
      //try {
         //text = new File(args[2]);
      text = "I am the big orange fox. I have come to eat your children and eat them. Please leave your children on the front porch so I can slaughter them and feast.";
         //if (!text.canRead()) {
            //throw new Exception();
         //}
      //}
      //catch (Exception e) {
         //System.out.println("Error: Could not open " + args[2] + ".");
         //return;
      //}
   
   
      // instantiate a MarkovModel with the supplied parameters and
      // generate sample output text ...
      
      MarkovModel model = new MarkovModel(K, text);
      String auxKgram = model.getRandomKgram();
      String output = auxKgram;
      int i = 0;
      
      while (i < M - K) {
         char c = model.getNextChar(auxKgram);
         output += c;
         auxKgram = auxKgram.substring(1) + c;
         i++; 
      }
      
      System.out.println(output);
   }
}
