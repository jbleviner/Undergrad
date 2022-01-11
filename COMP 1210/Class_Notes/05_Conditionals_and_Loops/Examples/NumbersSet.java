
/** 
 * A NumbersSet object represents two positive integer values and provides 
 * information about the numbers between those two values 
 * (including the two values themselves).
 */
public class NumbersSet 
{
   private int low, high; 

  /** 
   * Initializes a NumbersSet object given two positive integers.
   * The integers do not have to be in a specific order. 
   *
   * @param number1 Any positive integer 
   * @param number2 Any positive integer
   */
   public NumbersSet(int number1, int number2) 
   {
      if (number1 < number2) {
         low = number1;
         high = number2;
      }
      else {
         high = number1;
         low = number2;
      }
   }
   
   /**
    * @return value of low field
    */
   
   public int getLow() {
      return low;
   }
	
   /**
    * @return value of high field
    */
   public int getHigh() {
      return high;
   }
   
   /** 
	 * Returns a String including all even numbers 
	 * between low and high (inclusive) where
    * low and high are positive integers.          
	 *
	 * @return all even numbers between low and high inclusive
	 */
   public String findEvensBetween() {  
   
      String evens = "";
      
      int candidate = low;
      while (candidate <= high) {
         if (candidate % 2 == 0) {
            evens += candidate + " ";
         }
         candidate++;
      }
      	
      return evens;
   } 
   
   /** 
	 * Returns a String that includes the common divisors 
    * of low and high, by checking 1 through low (inclusive) 
    * where low and high are positive integers.         
	 *
	 * @return all common divisors of low and high 
	 */
   public String findCommonDivisors() {  
   
      String commonDivisors = "";
      
      int divisor = 1;  // begin with 1 
      while (divisor <= low) {  // and check through low
         if (low % divisor == 0 && high % divisor == 0) {
            commonDivisors += divisor + " ";
         }
         divisor++;
      }
      
      return commonDivisors;
   } 

   /** 
	 * Returns a String representation of this NumbersSet object
	 *
	 * @return string representation of high and low
	 */
   public String toString() {  
      return low + ", " + high;
   } 
}
