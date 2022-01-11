import static java.lang.Math.*;
import static java.lang.System.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Check_java_BigDecimal_arith {

   public static void main(String[] args) {
      
      double priceDouble = 1010.10;
      double taxDouble = 0.15;
      
      System.out.println("Using BigDouble Types from double parameters\n");
   
      BigDecimal price1 = new BigDecimal(1010.10);
      BigDecimal taxRate1 = new BigDecimal(0.15);
      BigDecimal tax1 = price1.multiply(taxRate1);
      BigDecimal total1 = price1.add(tax1);
      
      DecimalFormat fmt1 = new DecimalFormat("$#,##0.00");
      DecimalFormat fmt2 = new DecimalFormat("$#,##0.0000");
      
      System.out.println("price: " + fmt1.format(price1));
      System.out.println("taxRate: " + fmt1.format(taxRate1));
      System.out.println("tax: " + fmt1.format(tax1));
      System.out.println("total: " + fmt1.format(total1));
      System.out.println("\n");
      System.out.println("price: " + fmt1.format(price1));
      System.out.println("taxRate: " + fmt1.format(taxRate1));
      System.out.println("tax: " + fmt1.format(tax1));
      System.out.println("total: " + fmt1.format(total1));
      System.out.println("\n");
   
      
      System.out.printf("\nUsing BigDouble Types from String parameters\n\n");
      
      BigDecimal price2 = new BigDecimal("1010.10");
      BigDecimal taxRate2 = new BigDecimal("0.15");
      BigDecimal tax2 = price2.multiply(taxRate2);
      BigDecimal total2 = price2.add(tax2);
      
      System.out.printf("price: %.5f\n", price2);
      System.out.printf("taxRate: %.5f \n", taxRate2);
      System.out.printf("tax: %.5f \n", tax2);
      System.out.printf("total: %.5f \n", total2);
      System.out.printf("\n");
      System.out.printf("price: %.2f\n", price2);
      System.out.printf("taxRate: %.2f \n", taxRate2);
      System.out.printf("tax: %.2f \n", tax2);
      System.out.printf("total: %.2f \n", total2);
   
   }

}