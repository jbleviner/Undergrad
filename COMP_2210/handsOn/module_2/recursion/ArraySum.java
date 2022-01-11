/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Kevin Bumgarner
 * @version 2020-02-3
 */
public class ArraySum {

	/** Returns the sum of values in the given array. 
    * @param a (int[]) an array 
    * return sum() returns sum of array elements
    */
   public static int sum(int[] a, int left, int right) {
      if (a == null || a.length == 0 || left > right) {
         return 0;
      }
      return a[left] + sum(a, left + 1, right);
   }
}
