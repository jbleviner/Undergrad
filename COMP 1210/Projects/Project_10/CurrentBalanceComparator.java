import java.util.Comparator;

/**
 * Compares two Cardholder objects based on current balance.
 *
 * Project 10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 14th, 2018
 */

public class CurrentBalanceComparator 
   implements Comparator<Cardholder> {

   /**
    * Compares the current balance of two Cardholder objects.
    * 
    * @param c1 first object
    * @param c2 second object
    * @return -1, 0, 1, based on comparison
    */
    
   public int compare(Cardholder c1, Cardholder c2) {
      
      if (c1.currentBalance() < c2.currentBalance()) {
         return 1;
      }
      else if (c1.currentBalance() > c2.currentBalance()) {
         return -1;
      }
      else {
         return 0;
      }
   }
}