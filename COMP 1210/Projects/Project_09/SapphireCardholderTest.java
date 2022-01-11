import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Program test methods of 'SapphireCardholder.java'.
 *
 * Project 09
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 9th, 2018
 */
 
public class SapphireCardholderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
    * Tests getters and setters for 'SapphireCardHolder.java'.
    *
    */
    
   @Test public void gettersSettersTest() {
      
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      
      // Get and Set account number and name test
      sc.setName("Smith, Sam");
      sc.setAcctNumber("10001");
      Assert.assertEquals("get name test", "Smith, Sam", sc.getName());
      Assert.assertEquals("get acct number test", "10001", sc.getAcctNumber());
      
      // Get and Set previous balance test 
      sc.setPrevBalance(1200.0);
      Assert.assertEquals("get/set prev balance test", 
         1200.0, sc.getPrevBalance(), .000001);
      
      // Get and Set payment test 
      sc.setPayment(200);
      Assert.assertEquals("get/set payment test", 200, 
         sc.getPayment(), .000001);
      
      // Get and Set purchases test 
      double[] testArray = {12.3, 22, 5.4, 3, 44.5};
      sc.setPurchases(testArray);
      Assert.assertArrayEquals("get/set purchases test", 
         testArray, sc.getPurchases(), .000001); 
   }
   
   /**
    * Tests add purchases method.
    *
    */
    
   @Test public void addPurchasesTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      
      double[] addPurchasesTest = {34.5, 100.0, 63.50, 350.0};
      sc.addPurchases(34.5, 100.0, 63.50, 350.0);
      
      Assert.assertArrayEquals("add purchases test", 
         sc.getPurchases(), addPurchasesTest, .000001);
   }
   
   /**
    * Tests the delete purchases method.
    *
    */
    
   @Test public void deletePurchasesTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0);
      
      // Test if purchases were found
      sc.deletePurchases(100.0, 350.0);
      double[] delPurchasesTest = {34.5, 63.50};
      
      Assert.assertArrayEquals("delete purchases test", delPurchasesTest,
         sc.getPurchases(), .000001);
         
      // Test if not found
      sc.deletePurchases(50.5);
      
      Assert.assertArrayEquals("delete purchases test", delPurchasesTest,
         sc.getPurchases(), .000001); 
   }
    
   /**
    * Tests the interest method.
    *
    */
    
   @Test public void interestTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("interest test", 10, sc.interest(), 0.000001);
   }
   
   /**
    * Tests the totalPurchases method.
    *
    */
    
   @Test public void totalPurchasesTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("total purchases test", 548, 
         sc.totalPurchases(), 0.000001);
   }
   
   /**
    * Tests the balance method.
    *
    */
    
   @Test public void balanceTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("balance test", 1760, sc.balance(), .000001);
   }
   
   /**
    * Tests the current balance method.
    *
    */
    
   @Test public void currentBalanceTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("current balance test", 1558, 
         sc.currentBalance(), .000001);
   }
   
   /**
    * Tests the minPayment method.
    *
    */
    
   @Test public void minPaymentTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("min payment test", 46.74, 
         sc.minPayment(), .000001);
   }
   
   /**
    * Tests the toString method.
    *
    */
    
   @Test public void toStringTest() {
    
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
    
      String output = "Sapphire Cardholder\n";  
      output += "AcctNo/Name: 10001 Smith, Sam\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $10.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,558.00\n";
      output += "Minimum Payment: $46.74\n";
      output += "Purchase Points: 548";
      
      Assert.assertEquals("toString test", true, 
         sc.toString().contains(output));
   }
   
   //***************************************************************
   // Methods overridden in 'SapphireCardholder.java' 
   //***************************************************************
   
   /**
    * Tests the purchase points method.
    *
    */
    
   @Test public void purchasePointsTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      Assert.assertEquals("purchase points test", 548, 
         sc.purchasePoints(), .000001);
   }


}
