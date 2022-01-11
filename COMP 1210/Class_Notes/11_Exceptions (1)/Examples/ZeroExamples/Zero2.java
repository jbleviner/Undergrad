/**
 *  Zero2.java        
 *  Demonstrates the use of try-catch blocks to handle 
 *  (1) an ArithmeticException and (2) any other Exception.
 */

public class Zero2
{
   /**
    *  Divides by zero to produce an ArithmeticException.
    *  @param args - not used
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      try {
         System.out.println(numerator / denominator); // divide by zero
      } 
      // catch (ArithmeticException myProblem) {
         // System.out.println("An exception occured, " 
            //                + "and was handled: " + myProblem);
      // }
      catch (Exception myProblem) { // will catch any exception
         System.out.println("An exception occured, "
               				+ "and was handled: " + myProblem);
         myProblem.printStackTrace(); // indicates where exception occurred
      }
      
      System.out.println("Program completing normally."); 
   }
}
