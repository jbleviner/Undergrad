import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Program test methods of 'DiamondCardholder.java'.
 *
 * Project 09/10/11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public class DiamondCardholderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
    * Tests the getters and setters.
    *
    */
    
   @Test public void gettersSettersTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      
      // Get and Set discount rate test 
      dc.setDiscountRate(0.05);
      Assert.assertEquals("get/set discount rate", 0.05,
         dc.getDiscountRate(), .000001);
   }
   
   // *********************************************************
   // Methods overridden in 'DiamondCardholder.java'
   // ********************************************************* 
   
   /** 
    * Tests the purchase points method.
    *
    */
    
   @Test public void purchasePointsTest() {
    
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
      
      Assert.assertEquals("purchase points test", 1419, 
         dc.purchasePoints(), .000001); 
   }
   
   /**
    * Tests the total purchases method.
    *
    */
    
   @Test public void totalPurchasesTest() {
      
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
      
      Assert.assertEquals("total purchases test", 473.10, 
         dc.totalPurchases(), .000001);
       
   }
   
   /**
    * Tests the toString method.
    *
    */
    
   @Test public void toStringTest() {
    
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
      
      String output = "Diamond Cardholder\n";  
      output += "AcctNo/Name: 10002 Jones, Pat\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($0.00)\n";
      output += "Interest: $12.00\n";
      output += "New Purchases: $473.10\n";
      output += "Current Balance: $1,685.10\n";
      output += "Minimum Payment: $50.55\n";
      output += "Purchase Points: 1,419\n";
      output += "(includes 5.0% discount rate applied to New Purchases)";
      
      Assert.assertEquals("toString test", true, 
         dc.toString().contains(output));
   }
}
