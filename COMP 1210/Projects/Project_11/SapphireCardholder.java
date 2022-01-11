 /**
 * Program that defines Sapphire card accounts. 
 *
 * Project 09/10/11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public class SapphireCardholder extends Cardholder {

 // *************************************************
 // Constructor 
 // *************************************************

   /**
    * Initializes Sapphire card acounts.
    *
    * @param acctNumberIn account number 
    * @param nameIn name of cardholder
    */

   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Sapphire Cardholder";
   }
   
   /**
    * Calculates purchase points.
    *
    * @param 
    * @return points returns purchase points 
    */
   
   public int purchasePoints() {
      int points = 0;
      points = (int) Math.floor(totalPurchases()) * 1;
   
      return points;
   } 
}