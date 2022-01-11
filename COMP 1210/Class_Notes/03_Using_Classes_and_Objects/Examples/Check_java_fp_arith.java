import static java.lang.Math.*;
import static java.lang.System.*;

public class Check_java_fp_arith {

   public static void main(String[] args) {
      //int i;
      //char buffer[201]; 
      
      double price = 1010.10;
      double taxRate = 0.15;
      double tax = price * taxRate;
      double total = price + tax;
      
      System.out.printf("price: %.5f\n", price);
      System.out.printf("taxRate: %.5f \n", taxRate);
      System.out.printf("tax: %.5f \n", tax);
      System.out.printf("total: %.5f \n", total);
      System.out.printf("\n");
      System.out.printf("price: %.2f\n", price);
      System.out.printf("taxRate: %.2f \n", taxRate);
      System.out.printf("tax: %.2f \n", tax);
      System.out.printf("total: %.2f \n", total);
   }

}