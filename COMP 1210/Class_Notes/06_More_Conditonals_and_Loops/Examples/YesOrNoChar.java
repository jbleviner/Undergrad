import java.util.Scanner;

/** 
 * Using char in do-while expression.
 */
public class YesOrNoChar {

   /**
    * @param args - not used
    */
   public static void main(String[] args) {
      
      Scanner stdIn = new Scanner(System.in);
      char yOrN = ' ';
      do {
         System.out.print("Continue? (enter y or n): ");
         yOrN = stdIn.nextLine().trim().charAt(0);
      } while (yOrN != 'y' && yOrN != 'n');
      
      System.out.println("\r\nThe selection was " 
         + (yOrN == 'y' ? "y for Yes" : "n for No") + ".");
   }
}