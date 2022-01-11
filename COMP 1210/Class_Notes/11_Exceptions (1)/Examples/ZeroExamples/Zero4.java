/**
 *  Zero4.java        
 *  Demonstrates the use of try-catch-finally blocks with a 
 *  catch block for an ArithmeticException followed by a finally block.
 *  Conditionals demonstrate what happens with return statement and
 *  a call to System.exit(0) with respect to the finally block.
 */

public class Zero4
{
   /**
    *  Divides by zero to produce an ArithmeticException.
    *  @param args - not used
    */
   public static void main(String[] args)
   {
      int numerator = 10; // also set numerator to 1 and 1000
      int denominator = 0; // also set denominator to 1
      try
      {
         if (numerator > 500) {  // also make expression false
            System.out.println("Let's get out of here.");
            return;
         }
         if (numerator < 5) {  // also make expression false
            System.out.println("Let's get out of here.");
            System.exit(0);
         }
      
         System.out.println(numerator / denominator);
      }
      catch (ArithmeticException myProblem) 
      {
         System.out.println(myProblem.getMessage());
         myProblem.printStackTrace();
         System.out.println("The exception has been handled!");
      }
      finally
      {
         System.out.println("Wrapping up the try block.");	
      }
   
      System.out.println("Wrapping up the program.");
   
      System.out.println("Program completing normally."); 
   }
}
