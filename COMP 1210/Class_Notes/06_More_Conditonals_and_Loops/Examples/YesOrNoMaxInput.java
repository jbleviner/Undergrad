import java.util.Scanner;
/**
 * Demo of do-while loop where user enters "y" or "n"
 * for yes or no with a maximum of three tries.
 */
public class YesOrNoMaxInput {

   static final int MAX_TRIES = 3;
   
   /**
    * @param args - not used
    */
   public static void main(String[] args) {
      
      String userIn = "";
      boolean isValid = false;
      Scanner stdIn = new Scanner(System.in);
      int tries = 0;
      
      do {
         System.out.print("Continue? (enter y or n): ");
         userIn = stdIn.nextLine().trim();
         isValid = userIn.equals("y") || userIn.equals("n");
         if (!isValid) {
            if (++tries == MAX_TRIES) {
               System.out.println("Too many attempts - aborting");
               break;
            }   
            System.out.println("Error: \"" + userIn + "\" was entered.");
         }
      } while (!isValid);
      
      if (tries < MAX_TRIES) { // do the work here . . .
         System.out.println("\nThe selection was " 
            + (userIn.equals("y") ? "y for Yes" : "n for No") + ".");
      }
   }
}