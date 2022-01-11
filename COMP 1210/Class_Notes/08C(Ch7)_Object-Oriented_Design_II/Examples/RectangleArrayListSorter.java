import java.util.Collections;
import java.util.ArrayList;

public class RectangleArrayListSorter {

   public static void main(String[] args) {
      
      ArrayList<Rectangle> rList = new ArrayList<Rectangle>();
      
      rList.add(new Rectangle(2, 5));
      rList.add(new Rectangle(20, 50));
      rList.add(new Rectangle(5, 6));
      rList.add(new Rectangle(1, 4));
      rList.add(new Rectangle(6, 4));
            
      for (Rectangle r : rList) {
         System.out.println("\n" + r);
      }  
      
      Collections.sort(rList);
      
      System.out.println("\n- - - - - Sorted retangles  - - - - - - ");
      
      for (Rectangle r : rList) {
         System.out.println("\n" + r);
      }  
   }
}