import java.text.DecimalFormat;
/** Loan defines objects for employee and customer loan accounts. */
public class Loan {
 // Fields - instancse variables  
   private double balance = 0;
   private double interestRate;
   private double maxLoanAmount;
 // Constants  
   private static final double DEFAULT_INTEREST = 0.05;
   private static final double CUSTOMER_MAX = 10000;
   private static final double EMPLOYEE_MAX = 100000;   
   /**  */
   public static final int EMPLOYEE_ACCOUNT = 0;
   /**  */
   public static final int CUSTOMER_ACCOUNT = 1;
   
   /**  
    *  @param accountType to determine max loan.
    */
   public Loan(int accountType) {
      interestRate = DEFAULT_INTEREST;      
      if (accountType == EMPLOYEE_ACCOUNT) {
         maxLoanAmount = EMPLOYEE_MAX;
      }
      else {
         maxLoanAmount = CUSTOMER_MAX;
      }
   }
   
   /**  
    *  @return balance
    */
   public double getBalance() {
      return balance;
   }
      
   /**  
    *  @param interestRateIn to replace old interest.
    *  @return true if applied; otherwise false.
    */
   public boolean setInterestRate(double interestRateIn) {
      
      if (interestRateIn >= 0) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }

   /**  
    *  @param amount to be borrowed.
    *  @return true if amount is borrowed; otherwise false.
    */   
   public boolean borrow(double amount) {
      
      if (balance + amount <= maxLoanAmount) {
         balance += amount;
         return true;
      }
      else {
         return false;
      }
   }
      
   /**  
    *  @return calculated balance.
    */   
   public double totalBalance() {
      return balance * (1 + interestRate);
   }
   
   /**  
    *  @return String representing the Loan object.
    */   
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#0.0%");
      String output = "Loan amount: " 
            + df1.format(balance) + "\n" 
            + "Total balance with " + df2.format(interestRate) 
            + " interest: " + df1.format(totalBalance()) 
            + "\n";
      return output;
   }   
}
