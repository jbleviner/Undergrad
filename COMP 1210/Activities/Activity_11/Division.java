/**
 * Program that contains methods two divide two numbers.
 *
 * Activity 11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 25th, 2018
 */

public class Division {

/**
 * Divides two numbers using integer division.
 *
 * @param numeratorIn the numerator
 * @param denominatorIn the denominator
 * @return numeratorIn / denominatorIn returns result
 */
 
   public static int intDivide(int numeratorIn, int denominatorIn) {
      try {
         return numeratorIn / denominatorIn;
      }
      catch (ArithmeticException e) {
         return 0;
      }
   }

/**
 * Divides two numbers using decimal division.
 *
 * @param numeratorIn the numerator
 * @param denominatorIn the denominator
 * @return (float) numeratorIn / denominatorIn returns result
 */
 
   public static float decimalDivide(int numeratorIn, int denominatorIn) {
      
      if (denominatorIn == 0) {
       
         throw new IllegalArgumentException("The denominator "
            + "cannot be zero.");  
      }
   
      return (float) numeratorIn / denominatorIn;
   }

}