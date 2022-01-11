import java.text.DecimalFormat;
/**
 * Demo of half-even rounding in Java.
 *
 * Be sure run this program in the canvas 
 * (click button to right of debug button)
 * and drag the variable x from the debug 
 * tab onto the canvas.
 */
public class HalfEvenRoundingExamples {

   /**
    * Shows several examples of rounding in Java.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args) {
   
      DecimalFormat df = new DecimalFormat("#.##");
      double x; 
      
      x = 12.374;
      System.out.println("Pattern \"#.##\" prints 12.374 as: "
                        + df.format(x)
                        + " (rounded down)");
   
      x = 12.376;
      System.out.println("Pattern \"#.##\" prints 12.376 as: "
                        + df.format(x)
                        + " (rounded up)");
   
      x = 12.375;
      System.out.println("Pattern \"#.##\" prints 12.375 as: "
                        + df.format(x)
                        + " (5 digit rounded toward its nearest even neighbor 8)");
   
      x = 12.125;
      System.out.println("Pattern \"#.##\" prints 12.125 as: "
                        + df.format(x)
                        + " (5 digit rounded toward its nearest even neighbor 2)");
         
      x = 12.345;
      System.out.println("Pattern \"#.##\" prints 12.345 as: "
                        + df.format(x)
                        + " (rounded up)"
                        + "\n *** the numeric viewer shows that x > 12.345 "
                        + "\n     so in the formatted output the 4 in "
                        + "12.345 is rounded to 5. ");
   
      // observe 0.1 in a viewer (select Numeric viewer) to see that it
      // cannot be represented exactly; i.e., 0.1 has repeating bicimal 
      // places in base 2 so it is actually "rounded" to 0.1 rather than
      // exactly 0.1
      x = 0.1;
      System.out.println("\n0.1 prints as: "
                        + x
                        + "\n(but it's not exactly 0.1 because 0.1 has "
                        + "repeating bicimal places in binary)");
      
   }
}