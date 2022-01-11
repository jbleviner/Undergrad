/**
 * Prints integer values, counting and summing odd and even integers.
 *
 * Generate the CSD for this example to see how class, method, 
 * loop, and if statements are diagrammed.
 * Click "View" > "Generate CSD" on the jGRASP menu.
 *
 * Click the "Run in Canvas" button. On the canvas window, click 
 * the "Play" button. Regulate the speed with the "Delay" slider.
 * 
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Now drag the objects and primitives of interest from the 
 * Variables tab onto the canvas.  Arrange and click the "Play" 
 * button. Alternatively, you can click the "Step" and Step-in" 
 * buttons.
 */
public class OddEven {

   public static void main(String[] args) {
      int limit = 15;
      int odd = 0;
      int even = 0;
      int oddSum = 0;
      int evenSum = 0;
      for (int count = 1; count <= limit; count++) {
         System.out.print("\t" + count + " ");
         if (count % 2 != 0) {
            odd++;
            oddSum += count;
         }
         else {
            even++;
            evenSum += count;   
         }
         if (count % 5 == 0) {
            System.out.println();
         }                   
      }   
      System.out.println("\n# Even = " + even + "  Sum = " + evenSum);
      System.out.println("# Odd  = " + odd + "  Sum = " + oddSum);
   }
}
