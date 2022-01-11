/**
 * MinOfThree.java
 * Selects the minimum of three integer values. The logic of min1
 * has an error. (Corrected in Activity)
 *
 * @author   Dean Hendrix (dh@auburn.edu), Kevin Bumgarner (kgb0022@auburn.edu)
 * @version  2020-01-12
 *
 */
public class MinOfThree {

   /**
    * Driver for the class.
    * @param args arguments
    *
    */
   public static void main(String[] args) {
      System.out.println(min1(3, 1, 2));
      System.out.println(min2(3, 1, 2));
   }

   /**
    * Returns the minimum values of its three parameters.
    *
    * @param a the first value
    * @param b the second value
    * @param c the third value
    * @return  the minimum of a, b, and c
    */
   public static int min1(int a, int b, int c) {  	
      int[]	array = {a, b, c};
      int min = array[0];
      for (int elem :	array)	{
         if	(elem	<=	min) {
            min =	elem;
         }
      }
      return min;  	
   }

   /**
    * Returns the minimum values of its three parameters.
    *
    * @param a the first value
    * @param b the second value
    * @param c the third value
    * @return  the minimum of a, b, and c
    */
   public static int min2(int a, int b, int c) {
      if (a < b) {
         if (a < c) {
            return a;
         } 
         else if (c < a) {
            return c;
         } 
         else {
            return a;
         }
      } 
      else {
         if (b < c) {
            return b;
         } 
         else if (c < b) {
            return c;
         } 
         else {
            return b;
         }
      }
   }
}
