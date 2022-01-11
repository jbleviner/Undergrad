import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/**
 * Program that tests the methods of 'BankLoan.java'.
 *
 * Activity 08A
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 22nd, 2018
 */


public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
  
   
   /**
    * Test method for 'chargeInterest()'.
    *
    *
    */
   
   @Test public void chargeInterestTest() {
      
      BankLoan loan1 = new BankLoan("Jane", .10); 
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }
}
