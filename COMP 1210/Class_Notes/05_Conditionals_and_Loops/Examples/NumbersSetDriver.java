/**
 * Driver program for NumbersSet class.
 */
public class NumbersSetDriver {

   /**
    * @param args - not used
    */
   public static void main(String[] args) {
   
      NumbersSet numSet1 = new NumbersSet(3, 15);
      NumbersSet numSet2 = new NumbersSet(10, 20);
   
      String answer = numSet1.findEvensBetween();
      System.out.println("Evens between " + numSet1.getLow() 
               + " and " + numSet1.getHigh() + ": " +  answer);
   
      System.out.println("Common divisors of " + numSet1.getLow() 
               + " and " + numSet1.getHigh() + ": " 
               + numSet1.findCommonDivisors() + "\n");
         		
      System.out.println("Evens between " + numSet2.getLow() 
               + " and " + numSet2.getHigh() + ": " 
               + numSet2.findEvensBetween());
         
      System.out.println("Common divisors of " + numSet2.getLow() 
               + " and " + numSet2.getHigh() + ": " 
               + numSet2.findCommonDivisors() + "\n");
   }
}
