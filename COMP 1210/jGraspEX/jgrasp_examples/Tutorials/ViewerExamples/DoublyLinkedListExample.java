import jgraspvex.DoublyLinkedList;


/**
 * DoublyLinkedListExample - This example is intended to illustrate
 * the capabilities of the Presentation Structure Identifier
 * rendering of a doubly linked list structure in the viewer canvas.  
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
public class DoublyLinkedListExample {

   public static void main(String[] args) {
      while (true) {
         DoublyLinkedList list = new DoublyLinkedList();
         for (int i = 0; i < 3; i++) {
            System.out.println("Add: " + String.valueOf(i));
            list.add(String.valueOf(i));
         }
         
         System.out.println("Add: " + null);
         list.add(null);
         
         for (int i = 3; i >= 0; i--) {
            System.out.println("Insert: x" + String.valueOf(i)
                                 + " at position " + i);
            list.add(i, "x" + i);
         }
         
         for (int i = 0; i < 3; i++) {
            System.out.println("Remove element at positon: " + i);
            list.remove(i);
         }
      }
   }
}