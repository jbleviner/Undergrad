import jgraspvex.IntStack;

/**
 * IntStackExample - This example is intended to illustrate 
 * the capabilities of the viewer canvas and the structure 
 * identifier viewer when applied to stacks. 
 * 
 * Click the "Run in Canvas" button on the toolbar. Then on 
 * the canvas window, click the "Play" button. Regulate the 
 * speed with the "Delay" slider.
 * 
 * To end the program, click the "Stop" button on the canvas 
 * or click the "End" button on the Run I/O tab.   
 *
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you 
 * see objects and primitives of interest in the Variables tab 
 * and then drag them onto the canvas. Arrange the viewers and 
 * click the "Play" button. 
 * 
 * Alternatively, set a breakpoint, debug,
 * drag "stack" from the debug variables window to
 * pop up a viewer, and step repeatedly.
 */
public class IntStackExample {

   public static void main(String[] args) {
   
      while (true) {
         IntStack stack = new IntStack();
         for (int i = 0; i < 7; i++) {
            System.out.println("Push: " + (i * i));
            stack.push(i * i);
         }
         for (int i = 0; i < 7; i++) {
            System.out.println("Pop: " + stack.pop());
         }
      }
   }
}