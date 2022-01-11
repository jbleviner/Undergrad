import java.util.Scanner;

/**
 * Demonstrates various methods in the String class.
 */
public class StringExample2 {
   /**
    * Demonstrates various methods in the String class.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String input, replaced;
   
      System.out.print("Enter a string of your choice: ");
      input = scan.nextLine();
   
      System.out.println("\nThe string that you entered was: \n\"" 
         + input + "\"");
   	
      System.out.println("\nThe trimmed string is \""
         + input.trim() + "\".");
   
      System.out.println("\nThe first character is '"
         + input.charAt(0) + "'.");
   	
      System.out.println("The last character is '"
         + input.charAt(input.length() - 1) + "'.");
   	
      if (input.contains(" ")) {
         System.out.println("The string you entered contains at "
            + "least one space.");
      }
      else {
         System.out.println("The string you entered contain no spaces.");
      }
   	
      System.out.println();
      // Let's replace the vowels
      replaced = input;
      replaced = replaced.replace("a", "*");
      replaced = replaced.replace("e", "*");
      replaced = replaced.replace("i", "*");
      replaced = replaced.replace("o", "*");
      replaced = replaced.replace("u", "*");
      System.out.println("If the vowels are replaced with astericks, "
         + "your string would look as follows: ");
      System.out.println("\t" + replaced);
      
      System.out.println();
   
      //Let's find the first half of the message
      System.out.println("The first half of the input String: ");
      String firstHalf = input.substring(0, input.length() / 2);   
      System.out.println("\t\"" + firstHalf + "\"");
      
      //Let's find the last half of the message
      System.out.println("The second half of the input String: ");
      String secondHalf = input.substring(input.length() / 2);   
      System.out.println("\t\"" + secondHalf + "\"");
   }
}
