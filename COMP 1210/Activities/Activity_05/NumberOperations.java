/**
 * Program that defines a NumberOperations object 
 * referenced by numbers. 
 * 
 * Activity 5
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 1st, 2018
 */

public class NumberOperations {

// ==================
// Instance Variables
// ==================

   private int number = 0;
   
   // ===========
   // Constructor
   // ===========
   
   /**
    * Constructor that defines NumberOperations Objects.
    * 
    * @param numberIn a number 
    */
   
   public NumberOperations(int numberIn) {
      number = numberIn;
   }
   
   // =======
   // Methods
   // =======
   
   /**
    * Method to get number value.
    *
    * @param
    * @return number returns a number
    */
   
   public int getValue() {
      return number;
   }
   
   /**
    * Method to find all odd numbers under 'number'.
    * 
    * @param
    * @return output returns a list of numbers
    */ 
   
   public String oddsUnder() {
      
      int i = 0;
      String output = "";
      
      while (i < number) {
         
         if (i % 2 != 0) {
            output += i + "\t";
         }
         
         i++;
      }
      
      return output;
   } 
   
   /**
    * Method to find all powers of 2 under 'number'.
    * 
    * @param
    * @return output returns a list of numbers
    */
    
   public String powersTwoUnder() {
   
      String output = "";
      int powers = 1;
   
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
   
      return output;
   }
   
   /**
    * Method to compare two numbers.
    *
    * @param compareNumber a number
    * @return 1 returns indication of comparison  
    */
   
   public int isGreater(int compareNumber) {
   
      if (number > compareNumber) {
         return 1;
      }
      else if (number < compareNumber) {
         return -1;
      }
      else {
         return 0;
      }
       
   }
   
   /**
    * Method to give the NumberOperations object 
    * a string value.
    *
    * @param 
    * @return number + "" returns String 
    */
   
   public String toString() {
      return number + "";
   }
   
   public String summaryInfo() {
      return "";
   } 
}