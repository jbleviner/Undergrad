/**
 * We want make a package of goal pounds of chocolate. 
 * We have small bars (1 pound each) and big bars (5 pounds each). 
 * Return the number of small bars to use, assuming we always 
 * use big bars before small bars. Return -1 if it can't be done
 * [adapted from http://codingbat.com/prob/p191363]
 */
public class MakeChoclateExample { 

   /**
    * @param small number of small bars
    * @param big number of small bars
    * @param goal number of small bars
    * 
    * @return number of small bars to use (-1 if can't be done)    
    */
   public int makeChocolate(int small, int big, int goal) {
      return small - (goal - (big * 5 > goal ? goal / 5 : big) * 5) >= 0  
            ? (goal - (big * 5 > goal ? goal / 5 : big) * 5) : -1;
   }
   
   /**
    * @param args - not used
    */
   public static void main(String[] args) {
      MakeChoclateExample mce = new MakeChoclateExample();
      System.out.println("For small = 4, big = 1, and goal = 9,"
            + "\nsmall used = " + mce.makeChocolate(4, 1, 9)
            + " \n");
      System.out.println("For small = 4, big = 1, and goal = 10,"
            + "\nsmall used = " + mce.makeChocolate(4, 1, 10)
            + " \n");
      System.out.println("For small = 4, big = 1, and goal = 7,"
            + "\nsmall used = " + mce.makeChocolate(4, 1, 7)
            + " \n");
      System.out.println("Note that \"small used = -1\" "
            + "\nmeans the goal couldn't be reached.\n");
   }
}