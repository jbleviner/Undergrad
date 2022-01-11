import java.util.Arrays; 

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Kevin Bumgarner (kgb0022@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01/18/20
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a an array 
    * @return min returns the minimum value in a
    */    
   public static int min(int[] a) {
      if (a == null || a.length == 0) { // a is null or a has length 0 
         throw new IllegalArgumentException("a cannot be null" 
            + " or of length 0");
      }
      // Find Min
      int min = a[0];
      for (int number : a) {
         if (number < min) {
            min = number;
         }
      }
      return min;
   }

   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a an array of integers
    * @return max returns max value
    */    
   public static int max(int[] a) {    
      if (a == null || a.length == 0) { // a is null or a has length 0
         throw new IllegalArgumentException("a cannot be null"
            + " or of length 0");
      }
      // Find Max
      int max = a[0];
      for (int number : a) {
         if (number > max) {
            max = number;
         }
      }     
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *
    * @param a (int[]) an Array
    * @param k (int) kth minimum value indicator
    * @return kMin (int) returns the kth mimimum value
    */
   public static int kmin(int[] a, int k) {        
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }       
      
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      
      int distCount = 1;
      int kMin = min(b);
      int comp = b[0];
      for (int i = 0; i <= b.length - 1; i++) {
         if (b[i] != comp) {
            comp = b[i];
            distCount++;
         }
         if (k == distCount) {
            kMin = b[i];
         }
      }
      
      if (k > distCount) {
         throw new IllegalArgumentException();
      }
      
      return kMin;                  
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *
    * @param a (int[]) an Array
    * @param k (int) kth maximum value indicator
    * @return kMax (int) returns kth maximum value
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      } 
      
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      
      int distCount = 1;
      int comp = b[b.length -1];
      int kMax = max(b);        
      for (int i = b.length -1; i >= 0; i--) {
         if (b[i] != comp) {
            comp = b[i];
            distCount++;
         }
         if (k == distCount) {
            kMax = b[i];
         }
      }
      
      if (k > distCount) {
         throw new IllegalArgumentException();
      }
      
      return kMax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    *
    * @param a (int) an array
    * @param low (int) low boundry for range
    * @param high (int) high boundry for range
    * @return rangedArray returns an Array
    */
   public static int[] range(int[] a, int low, int high) {          
      if (a == null || a.length == 0) { // a is null or has length 0
         throw new IllegalArgumentException("a cannot be null"
            + " or of length 0");
      }
      // Produce ranged array
      int[] rangedArray = new int[0];
      int i = 0; 
      for (int number : a) {
         if ((number >= low) && (number <= high)) {
            i++;
            rangedArray = Arrays.copyOf(rangedArray, i);
            rangedArray[i - 1] = number;
         }
      }    
      return rangedArray;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *
    * @param a (int[]) an Array
    * @param key (int) a value used to find ceiling
    * @return sGK (int) returns smallest number greater than or equal to key
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0 || max(a) < key) { 
      // a is null or has length 0 or there is no qualifying value
         throw new IllegalArgumentException();
      }
      // Find Ceiling        
      int sGK = max(a);
      for (int number : a) {
         if ((number >= key) && (number <= sGK)) {
            sGK = number;
         }
      }              
      return sGK;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *
    * @param a (int[]) an array
    * @param key (int) a value used to find floor
    * @return lLK (int) returns largest number less than or equal to key 
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0 || min(a) > key) { 
      // a is null or length 0 or there is no qualifying value
         throw new IllegalArgumentException();
      } 
      // Find Floor
      int lLK = min(a);
      for (int number : a) {
         if ((number <= key) && (number >= lLK)) {
            lLK = number;
         }
      }
      return lLK;
   }

}
