/**
 * Demonstrates the use of the random() method in the Math class
 * to generate pseudo-random numbers.
 */
public class RandomNumbersExample2
{
   /**
    * Generates random numbers in various ranges using Math.random(),
    * which generates values in the range [0,1).
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args)
   {
      int randomInt;
      double randomDouble;
   
      randomDouble = Math.random();
      System.out.println("A random double in the range [0,1): " 
         + randomDouble);
         
      randomDouble = Math.random() * 10;  // 0.0 to 9.999999
      System.out.println("A random double (between 0-9.999999): "
         + randomDouble);
   
      randomInt = (int) (Math.random() * 10) + 1;
      System.out.println("From 1 to 10: " + randomInt);
   
      randomInt = (int) (Math.random() * 5);
      System.out.println("A random int in the range 0 to 4: " + randomInt);
      
      randomInt = (int) (Math.random() * 20) + 5;
      System.out.println("A random int in the range 5 to 24: " + randomInt);
   
      randomInt = (int) (Math.random() * 11) + 90;
      System.out.println("A random int in the range 90 to 100: " + randomInt);
   
      randomInt = (int) (Math.random() * 10) - 10;
      System.out.println("A random int in the range -10 to -1: " + randomInt);
   
   } 
}
