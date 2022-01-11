public class Loan {

   // Fields - instancse variables  
   private double balance = 0;
   private double interestRate;
   private double maxLoanAmount;
   
   // Constants  
   private static final double DEFAULT_INTEREST = 0.05;
   private static final double CUSTOMER_MAX = 10000;
   private static final double EMPLOYEE_MAX = 100000;   
   public static final int EMPLOYEE_ACCOUNT = 0;
   public static final int CUSTOMER_ACCOUNT = 1;

   // Constructor  
   public Loan(int accountType) {
   
   }
     
   // Methods  

   public double getBalance() {
      return balance; 
   }
   
   public boolean setInterestRate(double interestRateIn) {
      return false;
   }
   	
   public boolean borrow(double amount) {
      return false;
   }
   
   public double calculateTotalBalance() {
      return 0;
   }

   public String toString() {
      return "";
   }
}
