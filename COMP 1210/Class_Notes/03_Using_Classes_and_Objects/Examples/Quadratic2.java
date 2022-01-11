
import java.util.Scanner;
//import static java.lang.Math.*;
/** 
 ******************************************************************
 *  Quadratic.java  From: Lewis/Loftus - modified for complex roots
 *
 *  Demonstrates the use of the Math class to perform a calculation
 *  based on user input. 
 ******************************************************************
 */
public class Quadratic2
{
/** 
 * -----------------------------------------------------------------
 *  Determines the roots of a quadratic equation.
 *  @param args is not used.
 * -----------------------------------------------------------------
 */
   public static void main(String[] args)
   {
      int a, b, c;  // ax^2 + bx + c = 0
      double discriminant, root1, root2;
      
   
      Scanner scan = new Scanner(System.in);
      
      System.out.println("For the quadradic equation in the form "
         + "ax^2 + bx + c = 0, \nenter the "
         + "coefficients a and b and constant c.");
   
      System.out.print("\ta: ");
      a = scan.nextInt();
   
      System.out.print("\tb: ");
      b = scan.nextInt();
   
      System.out.print("\tc: ");
      c = scan.nextInt();
   
   // Use the quadratic formula to compute the roots.
   // Handles a positive or negative discriminant.
   
      discriminant = Math.pow(b, 2) - (4 * a * c);
      if (discriminant >= 0)
      {
         System.out.println("\nRoots are rational.");
         root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2.0 * a);
         root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2.0 * a);
      
         System.out.println("Root #1: " + root1);
         System.out.println("Root #2: " + root2);
      }
      else
      {
         System.out.println("\nRoots are irrational.");
         System.out.println("Root #1: " + (-1 * b) / (2.0 * a) + " + " 
            + Math.sqrt(-1 * discriminant) / (2.0 * a) + " i");
         System.out.println("Root #2: " + (-1 * b) / (2.0 * a) + " - " 
            + Math.sqrt(-1 * discriminant) / (2.0 * a) + " i");
      }
   }
}
