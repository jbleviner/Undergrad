//********************************************************************
//  AddMultiplyInts.java       
//********************************************************************
import java.util.Scanner;
/**
 * Demonstrates the use of for statements.
 */
public class AddMultiply 
{
 /**
 * 1. Adds from 1 to n using a for loop.
 * 2. Multiplies from 1 to n using a for loop
 *    (a.k.a. "n factorial" or "n!").
 *
 * @param args - not used.
 */
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("Add and multiply integers from 1 to ");
      int n = scan.nextInt();
   
   // for loop to add 1 to n:
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += i;  // sum = sum + i;
      }
      System.out.println("Sum: " + sum);
   
   // Equivalent while loop to add 1 to n:
      int sumW = 0;
      int j = 1;
      while (j <= n) {
         sumW += j; // sumW = sumW + j;
         j++;
      }
      System.out.println("SumW: " + sumW);
   
   // for loop to multiply 1 to n
      long product = 1; // ***Watch for wrong answer for large n.
      for (int k = 1; k <= n; k++) {
         product *= k; // product = product * k;
      }
      System.out.println("Product: " + product);
   
   // Equivalent while loop to multiply 1 to n:
      double productW = 1; // Best to use a double if n can be large
      int m = 1;
      while (m <= n) {
         productW *= m; // productW = productW * m;
         m++;
      }
      System.out.println("ProductW: " + productW);
   } 
}
