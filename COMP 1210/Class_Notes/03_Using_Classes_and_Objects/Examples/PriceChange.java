import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

/**
* Calculates the percent change between 2 prices.
*/
public class PriceChange {
   /**
    * Calculates the percent change between 2 prices.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args) {
      double initialPrice, finalPrice;
   
      Scanner input = new Scanner(System.in);
    
      NumberFormat percentFmt = NumberFormat.getPercentInstance();
      NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();  
   	
      System.out.print("Enter the initial price: ");
      initialPrice = input.nextDouble();
   
      System.out.print("Enter the final price: ");
      finalPrice = input.nextDouble();
      
      System.out.println("\r\nThe initial price that you entered was "
          + currencyFmt.format(initialPrice) + ".");
   	
      System.out.println("The final price that you entered was "
          + currencyFmt.format(finalPrice) + ".");
   	
      System.out.println("\r\nThere was approximately a " 
         + percentFmt.format((finalPrice - initialPrice) / initialPrice)
         + " change in price. [shown in CurrencyFormat]");
      System.out.println("\r\nThere was " 
         + currencyFmt.format(finalPrice - initialPrice) 
         + " change in price. [shown in CurrencyFormat]");
         
      // DecimalFormat could be used for percentage instead of 
      // CurrencyFormat by using the pattern "%".
      DecimalFormat dfPercent = new DecimalFormat("#0.0##%");
      System.out.println("\r\nThere was approximately a " 
         + dfPercent.format((finalPrice - initialPrice) / initialPrice)
         + " change in price. [shown in DecimalFormat]");
   
      // DecimalFormat could be used here instead of CurrencyFormat 
      // using 00 after the decimal point in the pattern will ensure 
      // that 2 decimal places are always included.
      DecimalFormat dollarFmt = new DecimalFormat("$#,##0.00");
      System.out.println("\r\nThere was " 
         + dollarFmt.format(finalPrice - initialPrice) 
         + " change in price. [shown in DecimalFormat]");      
   }
}
