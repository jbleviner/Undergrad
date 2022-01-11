import java.util.Scanner;

/** 
 *  Demonstrates try-catch-finally blocks for handling 
 *  NumberFormatException for non-numeric input when 
 *  parsing value from System.in (i.e., the keyboard).
 */
public class GuessNumber1 {

   /**
    *  Produces a NumberFormatException when a non-numeric
    *  value is entered as input.
    *  @param args - not used
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int num = (int) (Math.random() * 7 + 1);
      int guess = 0;
      int turnsRemaining = 3;
   
      while (guess != num && turnsRemaining > 0) {
      
         try {
            System.out.print(turnsRemaining 
               + (turnsRemaining == 1 ? " turn " : " turns ")
               + "remaining. Guess an integer from 1 to 7: ");
            guess =  Integer.parseInt(input.nextLine());
            System.out.print((guess < 1 || guess > 7) 
                              ? "Really? " : "Good guess. ");
         }
         
         catch (NumberFormatException issue) { // non-int inputs
            System.out.print("That wasn't even an integer ... ");
         }
               
         finally {
            turnsRemaining--;
         }
         
         if (guess == num) {
            System.out.println("You are right! Amazing!");
         }
         else {
            System.out.println("Sorry, it was wrong.");
         }   
      }
   }
}