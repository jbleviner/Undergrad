import java.util.Scanner;

/**
 * Demo of do-while loop where user enters "y" or "n"
 * for yes or no.
 */
public class YesOrNoInput {

   /**
    * @param args - not used
    */
   public static void main(String[] args) {
      
      Scanner stdIn = new Scanner(System.in);
      String yOrN = "";
      do {
         System.out.print("Continue? (enter y or n): ");
         yOrN = stdIn.nextLine().trim();
      } while (!yOrN.equals("y") && !yOrN.equals("n"));
      
      System.out.println("\r\nThe selection was " 
         + (yOrN.equals("y") ? "y for Yes" : "n for No") + ".");
   }
}