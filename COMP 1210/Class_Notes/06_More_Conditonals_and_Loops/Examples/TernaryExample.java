public class TernaryExample {

   public static void main(String[]args) {
   
      int small = 10;
      int big = 5;
      int goal = 23;
   
      System.out.println("Call makeChocolate: " 
              + makeChocolate(small, big, goal));
      System.out.println("Call makeChocolate: " 
              + makeChocolate(4, 1, 9));
      System.out.println("Call makeChocolate: " 
              + makeChocolate(4, 1, 10));
      System.out.println("Call makeChocolate: " 
              + makeChocolate(4, 1, 7));
   
      // System.out.println("Call makeChocolate2: " 
         //      + makeChocolate2(small, big, goal));
   }
   
   /**
      We want make a package of goal kilos of chocolate. 
      We have small bars (1 kilo each) and big bars (5 kilos each). 
      Return the number of small bars to use, assuming we always 
      use big bars before small bars. Return -1 if it can't be done.
      Examples:
         makeChocolate(4, 1, 9) -> 4 
         makeChocolate(4, 1, 10) -> -1 
         makeChocolate(4, 1, 7) -> 2
   
         http://codingbat.com/prob/p191363
         
         @param small number of small bars
         @param big   number of large bars
         @param goal  total number of bars
         @return number of small bars
    */
   
   public static int makeChocolate(int small, int big, int goal) {
      if(goal<5&&small>=goal)
      {
         return goal;
      }
   
      if(goal<5&&small<goal)
      {
         return -1;
      }
   
      if(goal>=5)
      {
         if(5*big>goal)
         {
            int temp=goal/5;
            if(goal-temp*5<=small)
            {
               return goal-temp*5;
            }
            if(goal-temp*5>small)
            {
               return -1;
            }
         }
      
         if(5*big<goal)
         {
            if(small<(goal-5*big))
            {
               return -1;
            }
            if(small>=(goal-5*big))
            {
               return goal-5*big;
            }
         }
      }
   
      return 0;    
   }

}