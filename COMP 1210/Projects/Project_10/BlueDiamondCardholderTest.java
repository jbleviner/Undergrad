import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Program test methods of 'BlueDiamondCardholder.java'.
 *
 * Project 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */

public class BlueDiamondCardholderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
    * Tests Getters and Setters.
    *
    */
    
   @Test public void gettersSettersTest() {
    
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", 
         "King, Kelly");
      
      // Get and Set bonus purchase points test
      bdc.setBonusPurchasePoints(2500);
      Assert.assertEquals("bonus test", 2500, 
         bdc.getBonusPurchasePoints(), .000001);
   }
   
   // ***********************************************
   // Methods overridden in 'BlueDiamond.java'
   // ***********************************************
   
   /**
    * Tests the purchase points method.
    *
    */
    
   @Test public void purchasePointsTest() {
    
    // Test for no bonus
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", 
         "King, Kelly"); 
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0); 
      bdc.setPrevBalance(1200.0);
      
      Assert.assertEquals("no bonus test", 2690,
         bdc.purchasePoints(), .000001);
    
    // Test for bonus
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("10004", 
         "Jenkins, Jordan"); 
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      
      Assert.assertEquals("bonus test", 47500, 
         bdc2.purchasePoints(), .000001);
   }
   
   /**
    * Tests the toString method.
    *
    */
    
   @Test public void toStringTest() {
    
      // Test for no bonus
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", 
         "King, Kelly"); 
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0); 
      bdc.setPrevBalance(1200.0);
    
      String output = "Blue Diamond Cardholder\n";  
      output += "AcctNo/Name: 10003 King, Kelly\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($0.00)\n";
      output += "Interest: $12.00\n";
      output += "New Purchases: $538.20\n";
      output += "Current Balance: $1,750.20\n";
      output += "Minimum Payment: $52.51\n";
      output += "Purchase Points: 2,690\n";
      output += "(includes 10.0% discount rate applied to New Purchases)";
      
      Assert.assertEquals("no bonus test", true,
         bdc.toString().contains(output));
         
      // Test for bonus
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("10004", 
         "Jenkins, Jordan"); 
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      
      String output2 = "Blue Diamond Cardholder\n";  
      output2 += "AcctNo/Name: 10004 Jenkins, Jordan\n";
      output2 += "Previous Balance: $1,200.00\n";
      output2 += "Payment: ($0.00)\n";
      output2 += "Interest: $12.00\n";
      output2 += "New Purchases: $9,000.00\n";
      output2 += "Current Balance: $10,212.00\n";
      output2 += "Minimum Payment: $306.36\n";
      output2 += "Purchase Points: 47,500\n";
      output2 += "(includes 10.0% discount rate applied to New Purchases)\n";
      output2 += "(includes 2,500 bonus points added to Purchase Points)";
   
      Assert.assertEquals("bonus test", true, 
         bdc2.toString().contains(output2));
   } 
}
