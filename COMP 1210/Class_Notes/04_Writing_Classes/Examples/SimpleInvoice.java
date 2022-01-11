import java.text.DecimalFormat;
/**================================
Credit Card Invoice.
==============================*/
public class SimpleInvoice
{
   private String name;
   private String accountNumber;
   private double interestRate;
   private double previousBalance;
   private double payment;
   private double newPurchases;


  /**  
   @param nameIn for name
   @param accountNumberIn for accountNumber
   @param interestRateIn for interestRate
   @param previousBalanceIn for previousBalance
   @param paymentIn for payment
   @param newPurchasesIn for newPurchases
  */
   public SimpleInvoice(String nameIn, String accountNumberIn,
                         double interestRateIn, 
                         double previousBalanceIn, double paymentIn,
                         double newPurchasesIn)
   {
      setName(nameIn);
      setAccountNumber(accountNumberIn);
      interestRate = interestRateIn;
      previousBalance = previousBalanceIn;
      payment = paymentIn;
      newPurchases = newPurchasesIn;  
   }
   
   /**  
     @return String
   */
   public String getName()
   {
      return name;
   }
   
   /**  
   
    @param nameIn for name
    @return boolean
   */
   public boolean setName(String nameIn)
   {
      if (nameIn == null) {
         return false;
      }
      else 
      {
         name = nameIn.trim();
         return true;
      }
   
   }   
   
   /**  
     @return String
   */
   public String getAccountNumber()
   {
      return accountNumber;
   }
   
   /**  
    @param accountNumberIn for accountNumber    
    @return boolean
   */
   public boolean setAccountNumber(String accountNumberIn)
   {
      if (accountNumberIn == null) 
      {
         return false;
      }
      else 
      {
         accountNumber = accountNumberIn.trim();
         //studentNumber = studentNumberIn;
         return true;
      }
   }  
   
   /**  
     @return double
   */
   public double getInterestRate()
   {
      return interestRate;
   }
   
   /**  
    @param interestRateIn for interestRate
   */
   public void setInterestRate(double interestRateIn)
   {
      interestRate = interestRateIn;
   }
 
   /**  
     @return double
   */
   public double getPreviousBalance()
   {
      return previousBalance;
   }
   
   /**  
    @param previousBalanceIn for previousBalance
   */
   public void setPreviousBalance(double previousBalanceIn)
   {
      previousBalance = previousBalanceIn;
   }
 
   /**  
    @return double
   */
   public double getPayment()
   {
      return payment;
   }
   
   /**  
    @param paymentIn for payment
   */
   public void setPayment(double paymentIn)
   {
      payment = paymentIn;
   }
 
   /**  
    @return double
   */
   public double getNewPurchases()
   {
      return newPurchases;
   }
   
   /**  
    @param newPurchasesIn for newPurchases
   */
   public void setNewPurchases(double newPurchasesIn)
   {
      newPurchases = newPurchasesIn;
   }
  
   /**  
    @param adjustment  to previousBalance
    @return double
   */   
   public double adjustPreviousBalance(double adjustment)
   {
      previousBalance += adjustment;
      return previousBalance;
   }
  
   /**  
    @param adjustment  to payment
    @return double
   */
   public double adjustPayment(double adjustment)
   {
      payment += adjustment;
      return payment;
   }

   /**  
    @return double
   */
   public double interest()
   {
      if (previousBalance - payment > 0) {
         return (previousBalance - payment) * interestRate;
      }
      else {
         return 0.0;
      }
   }
   

   /**  
    @return double
   */
   public double balance()
   {
      return previousBalance - payment + interest() + newPurchases;
   }
   
  /**  
   @return String
  */
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
   
      String result = "\nName: " + name 
                     + "\nAccount Number: " + accountNumber
                     + "\nPrevious Balance: " + df.format(previousBalance)
                     + "\nPayment: " + df.format(payment)
                     + "\nInterest: " + df.format(payment) + " at " 
                     + interestRate;
                     
      if (this.balance() >= 0) 
      {
         result += "\nCurrent Balance: " + df.format(balance());
      }
      else
      {   
         result += "\nCurrent Balance has Credit of: " 
                  + df.format(-1 * balance());
      }            
      return result;
   }

}