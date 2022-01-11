import java.util.Scanner;
/** 
 *  Demonstrates NumberFormatException for non-numeric input 
 *  when parsing value from System.in (i.e., the keyboard).
 */
public class AbsoluteValue1 {

   /**
    *  Produces a NumberFormatException when a non-numeric
    *  value is entered as input.
    *  @param args - not used
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double num = 0;
   
      do {
         System.out.print("Enter a number (0 to end): ");
         num = Double.parseDouble(input.nextLine());
         if (num == 0) {
            break;
         }
         System.out.println(num + " has an absolute value of: " 
                           + Math.abs(num));
      
      } while (true);
   
   }
}