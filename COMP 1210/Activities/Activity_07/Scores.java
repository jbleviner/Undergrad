/**
 * Program that defines an Array of numbers and holds 
 * methods to get the evens and odds of the array and
 * calculate the average of the array.
 *
 * Activity 07
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 15th, 2018
 *
 */
 
public class Scores {

   private int[] numbers;

// ================================================
// Constructor 
// ================================================ 

   /**
    * Initializes Scores objects.
    *
    * @param numbersIn numbers
    *
    */

   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }
   
   // =============================================
   // Methods 
   // =============================================
   
   /**
    * Finds even Scores.
    *
    * @param 
    * @return evens even numbers 
    */
   
   public int[] findEvens() {
      int numberEvens = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      
      int[] evens = new int[numberEvens]; 
      
      int count = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens; 
   }
   
   /**
    * Finds odd numbers. 
    *
    * @param 
    * @return odds odd numbers  
    */
   
   public int[] findOdds() {
      int numberOdds = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            numberOdds++;
         }
      }
      
      int[] odds = new int[numberOdds]; 
      
      int count = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
   }
   
   /**
    * Calculates average of numbers.
    *
    * @param
    * @return (double) sum / numbers.length Average 
    */
    
   public double calculateAverage() {
   
      int sum = 0;
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      } 
      return (double) sum / numbers.length;
   }
   
   /**
    * Creates a String representation of scores.
    *
    * @param 
    * @return result String value  
    */ 

   public String toString() {
      String result = "";
      
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      
      return result;
   }
   
   /**
    * Reverses 'toString'. 
    *
    * @param 
    * @return result String value 
    */
 
   public String toStringInReverse() {
      String result = "";
      
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      } 
      
      return result;
   }
}