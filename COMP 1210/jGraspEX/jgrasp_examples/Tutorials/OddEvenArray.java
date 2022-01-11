/**
 * Prints integer values in array, counting and summing 
 * odd and even integers.
 *
 * Generate the CSD for this example to see how class, 
 * method, loop, and if statements are diagrammed.
 * Click "Generate CSD" button on toolbar 
 * or click "View" > "Generate CSD" on the jGRASP menu.
 *
 * Click the "Run in Canvas" button on toolbar. 
 * Then on the canvas window, click the "Play" button. 
 * Regulate the speed with the "Delay" slider.
 * 
 * To create your own canvas, click the "Pause" button 
 * on the canvas.  Then on the Debug tab click the 
 * "Open Canvas" button. Now drag the objects and 
 * primitives of interest from the Variables tab onto 
 * the canvas.  Arrange and click the "Play" button. 
 * Alternatively, you can click the "Step" and Step-in" 
 * buttons.  See the "Canvas" tutorial for details on 
 * creating and using a canvas.
 */
public class OddEvenArray {

   public static void main(String[] args) {
      int[] intArray = {3, 12, 7, 6, 22, 19, 17};
      int odd = 0;
      int even = 0;
      int oddSum = 0;
      int evenSum = 0;
      for (int i = 0; i < intArray.length; i++) {
         System.out.print(intArray[i] + "   ");
         if (intArray[i] % 2 != 0) {
            odd++;
            oddSum += intArray[i];
         }
         else {
            even++;
            evenSum += intArray[i];   
         }
      }   
      System.out.println("\n# Even = " + even 
                        + "  Sum = " + evenSum);
      System.out.println("# Odd  = " + odd 
                        + "  Sum = " + oddSum);
   }
}
