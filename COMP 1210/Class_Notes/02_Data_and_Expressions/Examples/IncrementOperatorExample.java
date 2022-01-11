/**
 * Demonstrates the increment (++) operators.
 */
public class IncrementOperatorExample 
{
/**
 * Shows prefix and postfix forms.
 *   @param args - Standard commandline arguments
 */
   public static void main(String[] args)
   {
      int count = 0;
      
      System.out.println("count = " + count);
      System.out.println("10 + count++ = " 
         						+ (10 + count++));
      
      System.out.println("count = " + count);
      System.out.println("10 + ++count = " 
         						+ (10 + ++count));
      int seed = 1;
      int reed = 4;
      
      count = 0;                    
                           
      int a = count++;
    
      
      System.out.println(a);
      System.out.println(count);
      
      int guests = 0; 
      guests++;
      System.out.println(guests);       
   }
}
