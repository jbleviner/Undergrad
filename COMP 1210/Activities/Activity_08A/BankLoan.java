/**
 * Program that defines a bank loan.
 *
 * Activity 08A
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 22nd, 2018
 */

public class BankLoan {

// constant fields
 
   private static final int MAX_LOAN_AMOUNT = 100000;

// instance variables (can be used within the class)
 
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;
   
  
   
   // ================================================================
   // Constructor
   // ================================================================
   
   /**
    * Constructor.
    *
    * @param customerNameIn customer name 
    * @param interestRateIn interest rate 
    *
    */
    
   public BankLoan(String customerNameIn, double interestRateIn) {
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
    * Method to check if money was borrowed.
    *
    * @param amount amount of money
    * @return wasLoanMade true or false if loan happened
    *
    */
   
   public boolean borrowFromBank(double amount) {
      boolean wasLoanMade = false;
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
      return wasLoanMade;
   }
   
   /**
    * Calculates money payed o the bank.
    *
    * @param amountPaid amount paid
    * @return 0 returns amount paid
    */
   
   public double payBank(double amountPaid) {
      
      double newBalance = balance - amountPaid;
      
      if (newBalance < 0) {
         balance = 0;
      // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   /**
    * Gets balance. 
    *
    * @param 
    * @return balance returns balance 
    */
   
   public double getBalance() {
      return balance;
   }
   
   /**
    * Sets interest rate.
    *
    * @param interestRateIn interest rate 
    * @return true or false if correct IR happened 
    */
   
   public boolean setInterestRate(double interestRateIn) {
      
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      
      else {
         return false;
      }
   }
   
   /**
    * Gets Interest rate.
    *
    * @param
    * @return interestRate returns interest rate 
    */
   public double getInterestRate() {
      return interestRate;
   }
   
   /**
    * Charges interest rate.
    *
    * @param 
    * 
    */
   
   public void chargeInterest() {
      
      balance = balance * (1 + interestRate);
   }
   
   /**
    * Creates string representation of BankLoan objects.
    *
    * @param
    * @return output string
    */
   
   public String toString() {
      
      String output = "Name: " + customerName + "\r\n"
         + "Interest rate: " + interestRate + "%\r\n"
         + "Balance: $" + balance + "\r\n";
      
      return output;
   }
   
   /**
    * Checks for amount greater than 0.
    *
    * @param amount amount 
    * @return true or false if amount is greater than zero 
    */
   
   public static boolean isAmountValid(double amount) {
      
      if (amount >= 0) {
         return true;
      }
      
      return false;
    
   }
   
   /**
    * Checks if customer is in debt. 
    *
    * @param loan loan 
    * @return true or false if in debt 
    */ 
   
   public static boolean isInDebt(BankLoan loan) {
   
      if (loan.getBalance() > 0) {
         return true;
      }
     
      return false;
      
   }
   
   /**
    * Counts amount of loans created. 
    *
    * @param 
    * @return loansCreated returns amount of loans 
    */
   
   public static int getLoansCreated() {
      return loansCreated;
   }
   
   /**
    * Resets loans. 
    *
    * @param
    * 
    */
   
   public static void resetLoansCreated() {
      loansCreated = 0;
   }
}
