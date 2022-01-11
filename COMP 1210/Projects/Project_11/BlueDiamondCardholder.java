import java.text.DecimalFormat;

/**
 * Program that defines Sapphire card accounts. 
 *
 * Project 09/10/11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public class BlueDiamondCardholder extends DiamondCardholder {

  // **********************************************
  // Instance Variables
  // **********************************************
  
   private int bonusPurchasePoints = 2500;


  // **********************************************
  // Constructor 
  // **********************************************
  
   /**
    * Initializes Blue diamond card acounts.
    *
    * @param acctNumberIn account number 
    * @param nameIn name of cardholder
    */
    
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
      discountRate = 0.10;
   }
   
   /**
    * Gets bonus purchase points.
    *
    * @param 
    * @return bonusPurchasePoints returns points 
    */
    
   public int getBonusPurchasePoints() {
      return bonusPurchasePoints;
   }
   
   /**
    * Sets bonus purchase points.
    *
    * @param bonusPurchasePointsIn bonus purchase points 
    */
    
   public void setBonusPurchasePoints(int bonusPurchasePointsIn) {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }
   
   /**
    * Calculates purchase points.
    *
    * @param
    * @return points returns purchase points
    */
    
   public int purchasePoints() {
      int points = 0;
      points = (int) Math.floor(totalPurchases()) * 5;
      
      if (totalPurchases() > 2500.00) {
         points += 2500;
      } 
   
      return points;
   }
   
   /**
    * Creates a String value for BlueDiamond card accounts.
    *
    * @param 
    * @return output returns string
    */
    
   public String toString() {
      
      DecimalFormat f = new DecimalFormat("$#,##0.00");
      DecimalFormat fpp = new DecimalFormat("#,##0");
      DecimalFormat dR = new DecimalFormat("0.0%");
   
      String output = category + "\n";  
      output += "AcctNo/Name: " + getAcctNumber() + " " + getName() + "\n";
      output += "Previous Balance: " + f.format(getPrevBalance()) + "\n";
      output += "Payment: (" + f.format(getPayment()) + ")\n";
      output += "Interest: " + f.format(interest()) + "\n";
      output += "New Purchases: " + f.format(totalPurchases()) + "\n";
      output += "Current Balance: " + f.format(currentBalance()) + "\n";
      output += "Minimum Payment: " + f.format(minPayment()) + "\n";
      output += "Purchase Points: " + fpp.format(purchasePoints()) + "\n";
      output += "(includes " + dR.format(discountRate) 
         + " discount rate applied to New Purchases)";
         
      if (totalPurchases() > 2500.00) {
         output += "\n(includes " + fpp.format(bonusPurchasePoints) 
            + " bonus points added to Purchase Points)";
      } 
         
      return output;
   }
}