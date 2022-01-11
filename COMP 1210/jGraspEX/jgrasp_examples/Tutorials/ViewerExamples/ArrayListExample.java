import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListExample - This example is intended to illustrate
 * the capabilities of the array viewer, ArrayList viewer, and 
 * the viewer canvas in jGRASP.  String array elements are added
 * to and removed from an ArrayList.
 * 
 * Click the "Run in Canvas" button. On the canvas window, click 
 * the "Play" button. Regulate the speed with the "Delay" slider.
 * 
 * To end the program, click the "Stop" button on the canvas 
 * or click the "End" button on the Run I/O tab.   
 *
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Now drag the objects and primitives of interest from the 
 * Variables tab onto the canvas.  Arrange and click the "Play" 
 * button. Alternatively, you can click the "Step" and Step-in" 
 * buttons.
 */
public class ArrayListExample {

   public static void main(String[] args) {
      List list;
      String[] stringList = {"cat", "dog", "ant", "monkey", "flea"};
      list = new ArrayList();
      
      while (true) {
         for (int i = 0; i < stringList.length; i++) {
            list.add(stringList[i]);
            System.out.println(list);
         }  
         list.remove(3);
         System.out.println(list);
         list.add(3, "rat");
         System.out.println(list);
         list.add(3, stringList[2]); 
         System.out.println(list);
         list.clear();
      }
   }
}