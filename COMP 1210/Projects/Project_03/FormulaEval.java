import java.util.Scanner;
import java.text.DecimalFormat;

/** 
 * Program to get user input for "x" placed inside of an equation,
 *     calculate a result, count the numbers to the right and left of the
 *     decimal point of result and then format the result.
 * Program then prints the result, numbers to the right of the decimal,
 *     numbers to the left of the decimal, and a formatted result.  
 *
 * Project 3 
 * @author Kevin Bumgarner - COMP 1210 - 003
 * @version septemeber 14th, 2018
 */

public class FormulaEval {
   
 /**
  * Gets user input, calculates expression using input,
  *   and prints statement based on results.  
  * 
  * @param args Command line arguments - not used 
  */
  
   public static void main(String[] args) {
      
      // Declare variables
      Scanner userX = new Scanner(System.in);
      DecimalFormat resultFormat = new DecimalFormat("#,##0.0####");  
      double x;
      double result;
      double result1;
      double result2;
      String resultString;
      String resultFinal;
      String left;
      int left1;
      String right;
      int right1;
      int decimal;
       
      // Get x from user 
      System.out.print("Enter a value for x: ");
      x = Double.parseDouble(userX.nextLine());
      
      // Calculate and print result
      result1 = (1000 * x) 
         + Math.sqrt(Math.abs((3.9 * Math.pow(x, 5)) - (Math.pow(x, 3)) + 1));
      result2 = ((1.6 * Math.pow(x, 2)) + (2.7 * x) + 3.8);
      result = result1 / result2;
      System.out.println("Result: " + result);
      
      // Convert result to a string 
      resultString = Double.toString(result);
      
      // Count numbers to the left and right of the decimal and print 
       
      decimal = resultString.indexOf(".");
      
      left = resultString.substring(0, decimal);
      left1 = left.length();
      
      right = resultString.substring(decimal + 1);
      right1 = right.length();
      
      System.out.println("# of characters to left of decimal point: " + left1);
      System.out.println("# of characters to right of decimal point: " 
         + right1);
      
      // Format answer and print
      resultFinal = resultFormat.format(result);
      System.out.print("Formatted Result: " + resultFinal);
      
   }
}