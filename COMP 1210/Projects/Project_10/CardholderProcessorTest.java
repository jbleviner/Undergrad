import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * Tests the methods of 'CardholderProcessor.java'.
 *
 * Project 10 
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 16th, 2018 
 */


public class CardholderProcessorTest {

   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   
   @Before public void setUp() {
   }
   
   /**
    * Tests getCardholdersArray() & getInvalidRecordsArray().
    *
    */
    
   @Test public void gettersTest() {
   
   }
    
   /**
    * Tests addCardholder().
    *
    */
     
   @Test public void addCardholderTest() {
   
   // Ex. Test CardholderProcessor 
      CardholderProcessor cP = new CardholderProcessor();
     
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
   
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
   
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", 
         "King, Kelly"); 
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0); 
      bdc.setPrevBalance(1200.0);
   
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("10004", 
         "Jenkins, Jordan"); 
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      
      // Add cardholder
      cP.addCardholder(sc);
      cP.addCardholder(bdc2);
      
      // Ex. Test Array/ USES GETTER 
      Cardholder[] cA = cP.getCardholdersArray();
      
      // Test 
      Assert.assertEquals("Add test", cA[0], sc);
      Assert.assertEquals("Add test", cA[1], bdc2); 
   }
     
   /**
    * Tests addInvalidRecord().
    *
    */ 
      
   @Test public void addInvalidRecordTest() {
     // Ex. Test Array, processor, String
      CardholderProcessor cP = new CardholderProcessor();
      String invalidRecord = "Invalid Record";
      
      // Add invalid Record
      cP.addInvalidRecord(invalidRecord);
      
      // Get invalid Record Array
      String[] iR = cP.getInvalidRecordsArray();
   
      Assert.assertEquals("Invalid record test", iR[0], invalidRecord); 
      
   }
      
   /**
    * Tests readCardholderFile().
    *
    * @throws FileNotFoundException if file is not found
    */
       
   @Test public void readCardholderFileTest() 
       throws FileNotFoundException {
       
       // Ex. Test processor 
      CardholderProcessor cP = new CardholderProcessor();
       
       // Read file into cP and create test Array 
      cP.readCardholderFile("cardholder_data_1.txt");
      Cardholder[] cA = cP.getCardholdersArray(); 
      String[] iR = cP.getInvalidRecordsArray();
      
       //Test if read in
      Assert.assertEquals("Test read file", cA.length, 4, 0.000001); 
      Assert.assertEquals("Test read file2", iR.length, 1, 0.000001);
   }
   
   /**
    * Tests generateReport().
    * @throws FileNotFoundException if file not found  
    */
    
   @Test public void generateReportTest() throws FileNotFoundException {
      
      // String contained in Actual output
      String output = "Sapphire Cardholder\n";  
      output += "AcctNo/Name: 10001 Smith, Sam\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $10.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,558.00\n";
      output += "Minimum Payment: $46.74\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_1.txt");
   
      // Test method
      Assert.assertTrue("GR test", cP.generateReport().contains(output));
   }
   
   /**
    * Tests generateReportByName().
    * @throws FileNotFoundException if file not found 
    */
    
   @Test public void generateReportByNameTest() 
      throws FileNotFoundException {
      
      // String contained in Actual output
      String output = "Sapphire Cardholder\n";  
      output += "AcctNo/Name: 10001 Smith, Sam\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $10.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,558.00\n";
      output += "Minimum Payment: $46.74\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_1.txt");
   
      // Test method
      Assert.assertTrue("GRN test", 
         cP.generateReportByName().contains(output));
   }
   
   /**
    * Tests generateReportByCurrentBalance().
    * @throws FileNotFoundException if file not found
    */
    
   @Test public void generateReportByCurrentBalanceTest() 
      throws FileNotFoundException {
      
      // String contained in Actual output
      String output = "Sapphire Cardholder\n";  
      output += "AcctNo/Name: 10001 Smith, Sam\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $10.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,558.00\n";
      output += "Minimum Payment: $46.74\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_1.txt");
   
      // Test method
      Assert.assertTrue("GRCB test", 
         cP.generateReportByCurrentBalance().contains(output));
   }
}
