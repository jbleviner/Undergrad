import java.util.ArrayList;
import java.util.List;

  /** ArrayListExample1 -- This example is intended to illustrate
*  the capabilities of the ArrayList viewer in jGRASP.
*  Set a breakpoint inside the loop and launch the debugger.
*  After program stops at the breakpoint, open a viewer on 
*  the variable list by "dragging" list out of the Debug tab 
*  and releasing it. Now step through the program and observe 
*  the ArrayList viewer. **/
public class ArrayListExample1 {
 
 
   public static void main(String[] args) { 
      List list;
      String[] stringList = {"cat", "dog", "ant", "monkey", "flea"};
      list = new ArrayList();   
      for (int i = 0; i < stringList.length; i++) {
         list.add(stringList[i]);
      }   
      list.remove(3);
      list.add(3 , "rat");
   }
}