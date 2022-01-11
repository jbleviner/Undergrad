import java.text.DecimalFormat;

/**
 * Demonstrates the use of the DecimalFormat 
 * class.
 */
public class DecimalFormatExamples
{
/**
* Declares and intializes some doubles then
* prints them using instances of DecimalFormat.
*
* @param args Command-line arguments (unused). 
*/
   public static void main(String[] args)
   {
      double x1 = 12345.6789;
      DecimalFormat fmt1 = new DecimalFormat("0.###E0");     
      System.out.println("Pattern \"0.###E0\" prints 12345.6789 as: " 
                        + fmt1.format(x1));
   
      double x2 = 123456789.87654321;
      DecimalFormat fmt2 = new DecimalFormat("0.###E00");     
      System.out.println("Pattern \"0.###E00\" prints 123456789.87654321 as: " 
                        + fmt2.format(x2));
      
      // three decimal places; always print at least one decimal place
      DecimalFormat fmt3 = new DecimalFormat("#.0##");
      double x3 = 4.123456789;
      System.out.println("Pattern \"#.0##\" prints 4.123456789 as: "
                        + fmt3.format(x3));
      
      // dollars with two decimal places, parens around negative value.
      // 
      DecimalFormat fmt4 = new DecimalFormat("$#,##0.00;($#,##0.00)");
      double x4 = -112345678.123567;
      System.out.println("Pattern \"$#,##0.00;($#,##0.00)\" prints "
                        + "-112345678.123567 as: "
                        + fmt4.format(x4));
      
      DecimalFormat fmt5 = new DecimalFormat("$**#,###.00");
      double x5 = 112345678.123567;
      System.out.println("Pattern \"$**#,###.00\" prints 112345678.123567 as: "
                        + fmt5.format(x5));
   
      DecimalFormat fmt6 = new DecimalFormat("0.###");
      double x6 = 11.0;
      System.out.println("Pattern \"0.###\" prints 11.0 as: " 
                        + fmt6.format(x6));
   
      DecimalFormat fmt7 = new DecimalFormat("#.###");
      double x7 = 0.5;
      System.out.println("Pattern \"#.###\" prints 0.5 as: " 
                        + fmt7.format(x7));
   	
      DecimalFormat fmt8 = new DecimalFormat(".###");
      double x8 = 0.5;
      System.out.println("Pattern \".###\" prints 0.5 as: " 
                        + fmt8.format(x8));
   
      DecimalFormat fmt9 = new DecimalFormat(".###");
      double x9 = 1234.56789;
      System.out.println("Pattern \".###\" prints 1234.56789 as: " 
                        + fmt9.format(x9));
   
      DecimalFormat fmt10 = new DecimalFormat("#.##%");
      double x10 = 0.123456;
      System.out.println("Pattern \"#.##%\" prints 0.123456 as: " 
                        + fmt10.format(x10));
   
      DecimalFormat fmt11 = new DecimalFormat("00000");
      int x11 = 123;
      System.out.println("Pattern \"00000\" prints 123 as: " 
                        + fmt11.format(x11));
   
   }
}
