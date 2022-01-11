import java.text.DecimalFormat;

/**
 * Program that defines Diamond card accounts. 
 *
 * Project 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public class DiamondCardholder extends Cardholder {

  // **********************************************
  // Instance Variables
  // **********************************************
  
   protected double discountRate = 0.05;
   
   // *********************************************
   // Constructor
   // *********************************************
   
   /**
    * Initializes Diamond card acounts.
    *
    * @param acctNumberIn account number 
    * @param nameIn name of cardholder
    */

   public DiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Diamond Cardholder";
   }
   
   /**
    * Gets the discount rate. 
    *
    * @param 
    * @return discountRate returns discount rate
    */
    
   public double getDiscountRate() {
      return discountRate;
   }
    
   /**
    * Sets discount rate.
    *
    * @param discountRateIn discount rate
    */
     
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   } 
   
   /**
    * Calculates purchase points.
    *
    * @param
    * @return points returns purchase points
    */
    
   public int purchasePoints() {
      int points = 0;
      points = (int) Math.floor(totalPurchases()) * 3;
   
      return points;
   }
   
   /**
    * Calculates discounted total of purchases. 
    *
    * @param 
    * @return discountedTotal returns discounted total 
    */
    
   public double totalPurchases() {
      double total = 0;
      double discountedTotal = 0;
    
      for (double x : purchases) {
         total += x;
      }
      
      discountedTotal = total * (1 - discountRate);
      
       
      return discountedTotal;
   } 
   
   /**
    * Creates a String value representing DiamondCardholder objects.
    *
    * @param 
    * @return output returns String
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
         
      return output;
   }
}