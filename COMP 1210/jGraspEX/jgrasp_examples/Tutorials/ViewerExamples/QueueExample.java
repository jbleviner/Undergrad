import jgraspvex.Queue;

/**
 * QueueExample.java -- This example is intended to illustrate
 * the capabilities of the Presentation Structure Identifier
 * rendering of a "queue" structure in the viewer canvas.  
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
 */
public class QueueExample {

   public static void main(String[] args) {
    
      while (true) {
         Queue queue = new Queue();
         for (int i = 0; i < 15; i++) {
            queue.add(new Integer(i * i));
            if ((i % 2) == 1) {
               queue.remove();
            }
            System.out.println(queue);
         }
         queue.clear();
      }
   }
}