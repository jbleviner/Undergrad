import java.util.Arrays;
import java.text.DecimalFormat;
   
/**
 * Abstract class inhereited by 'SapphireCardholder', DiamondCardholder',
 *    and 'BlueDiamondCardholder'. 
 *
 * Project 09/10/11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public abstract class Cardholder implements Comparable<Cardholder> {

   //***************************************************
   // Instance Variables
   //***************************************************
 
   protected String category, acctNumber, name = "";
   protected double prevBalance, payment = 0;
   protected double[] purchases;
   protected int count;
   
   //***************************************************
   // Constants
   //***************************************************
   
   /**
    * Constant INTEREST_RATE interest rate. 
    */
    
   public static final double INTEREST_RATE = 0.01;  
   
   //***************************************************
   // Constructor 
   //***************************************************
   
   /**
    * Constructor for new Cardholder objects.
    *
    * @param acctNumberIn acctNumber 
    * @param nameIn name 
    */
    
   public Cardholder(String acctNumberIn, String nameIn) {
      
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }
   
   /**
    * Gets account number.
    *
    * @param 
    * @return acctNumber returns account number
    */
   
   public String getAcctNumber() {
      return acctNumber;
   }
   
   /**
    * Sets account number.
    *
    * @param acctNumberIn account number 
    */
   
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
   
   /**
    * Gets name.
    *
    * @param
    * @return name returns name of cardholder
    */
    
   public String getName() {
      return name;
   }
   
   /**
    * Sets name.
    *
    * @param nameIn name 
    */
   
   public void setName(String nameIn) {
      name = nameIn;
   }
   
   /**
    * Gets previous balance.
    *
    * @param 
    * @return prevBalance returns previous balance
    */
   
   public double getPrevBalance() {
      return prevBalance;
   }
   
   /**
    * Sets previous balance.
    *
    * @param prevBalanceIn previous balance
    */ 
   
   public void setPrevBalance(double prevBalanceIn) {
      prevBalance = prevBalanceIn;
   }
   
   /** 
    * Gets payment.
    *
    * @param 
    * @return payment returns payment
    */
   
   public double getPayment() {
      return payment;
   }
   
   /**
    * Sets payment.
    *
    * @param paymentIn previous balance
    */ 
   
   public void setPayment(double paymentIn) {
      payment = paymentIn;
   }
   
   /**
    * Gets purchases.
    *
    * @param
    * @return purchases returns purchases
    */
    
   public double[] getPurchases() {
      return purchases;
   }
   
   /**
    * Sets purchases.
    * 
    * @param purchasesIn purchases
    */
    
   public void setPurchases(double[] purchasesIn) {
      purchases = purchasesIn; 
   }
   
   /**
    * Adds purchases.
    *
    * @param purchasesIn purchases added 
    */
    
   public void addPurchases(double... purchasesIn) {
      
      // Get original length and make index for added purchases 
      int orig = purchases.length;
      int indexIn = 0;
      
      // create copy of purchases[] and extend its length 
      purchases = Arrays.copyOf(purchases, purchases.length
         + purchasesIn.length);
     
      // Iterate through non initialized indecies of purchases[] 
      // Assign values to those indecies     
      for (int i = orig; i < purchases.length; i++) {
         purchases[i] = purchasesIn[indexIn];
         indexIn++;
      }  
           
   } 
   
    /**
     * Deletes purchases.
     *
     * @param purchasesIn purchases deleted
     */
     
   public void deletePurchases(double... purchasesIn) {
   
      for (int i = 0; i < purchases.length; i++) {
         
         for (double x : purchasesIn) {
            
            if (Math.abs(purchases[i] - x) < 0.000000000001) {
               
               for (int j = i; j < purchases.length - 1; j++) {
                  purchases[j] = purchases[j + 1];
                 
               }
               
               purchases = Arrays.copyOf(purchases, 
                  purchases.length - 1);
            }
         }
      }
   }
   
   /**
    * Calculates interest.
    *
    * @param 
    * @return interest returns interest 
    */
    
   public double interest() {
      double interest = (getPrevBalance() - payment) * INTEREST_RATE;
      return interest;
   }
   
   /**
    * Calculates the total of purchases.
    *
    * @param 
    * @return total returns total of purchases
    */
    
   public double totalPurchases() {
      double total = 0;
    
      for (double x : purchases) {
         total += x;
      } 
      return total;
   }
   
   /**
    * Calculates balance.
    *
    * @param
    * @return balance calculated balance 
    */
    
   public double balance() {
      double balance = (getPrevBalance() * (1 + INTEREST_RATE)) 
         + totalPurchases();
      return balance; 
   }
   
   /**
    * Calculates current balance.
    *
    * @param
    * @return current current balance 
    */
    
   public double currentBalance() {
      double current = getPrevBalance() - getPayment() 
         + interest() + totalPurchases();
      return current; 
   }
   
   /**
    * Calculates minimum payment.
    *
    * @param 
    * @return min returns minimum payment  
    */
    
   public double minPayment() {
      double min = currentBalance() * 0.03;
      return min;
   }
   
   /**
    * Abstract: purchase points.
    * @return int returns int value 
    */
    
   public abstract int purchasePoints();
    
   /**
    * Creates a to String value for sub classes.
    *
    * @param
    * @return output returns String 
    */
    
   public String toString() {
      DecimalFormat f = new DecimalFormat("$#,##0.00");
      DecimalFormat fpp = new DecimalFormat("#,##0");
   
      String output = category + "\n";  
      output += "AcctNo/Name: " + getAcctNumber() + " " + getName() + "\n";
      output += "Previous Balance: " + f.format(getPrevBalance()) + "\n";
      output += "Payment: (" + f.format(getPayment()) + ")\n";
      output += "Interest: " + f.format(interest()) + "\n";
      output += "New Purchases: " + f.format(totalPurchases()) + "\n";
      output += "Current Balance: " + f.format(currentBalance()) + "\n";
      output += "Minimum Payment: " + f.format(minPayment()) + "\n";
      output += "Purchase Points: " + fpp.format(purchasePoints());
         
      return output;
   }
   
   /**
    * Compares the names of two Cardholders.
    *
    * @param obj object being compared
    * @return this returns int 
    */
    
   public int compareTo(Cardholder obj) {
      return this.name.compareToIgnoreCase(obj.name);
   }
}
