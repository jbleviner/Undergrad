/**
 *  Zero3.java        
 *  Demonstrates the use of try-catch-finally blocks with a 
 *  catch block for an ArithmeticException followed by a finally block.
 */

public class Zero3 
{
   /**
    *  Divides by zero to produce an ArithmeticException.
    *  @param args - not used
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      try 
      {
         System.out.println(numerator / denominator);
      }
      catch (ArithmeticException myProblem) 
      {
         System.out.println("An exception occured, " 
                           + "and was handled: " + myProblem);
      }
      finally
      {
         System.out.println("Since in 'finally', this is always printed!");
      }
   
      System.out.println("This text will [not] be printed.");
   }
}
