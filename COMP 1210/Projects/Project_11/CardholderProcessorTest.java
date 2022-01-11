import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
   
/**
 * Tests the methods of 'CardholderProcessor.java'.
 *
 * Project 10/11 
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 29th, 2018 
 */


public class CardholderProcessorTest {

   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   
   @Before public void setUp() {
   }
   
 // Getters are exercised in the following tests
    
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
      cP.readCardholderFile("cardholder_data_3_exceptions.txt");
      Cardholder[] cA = cP.getCardholdersArray(); 
      String[] iR = cP.getInvalidRecordsArray();
      
       //Test if read in
      Assert.assertEquals("Test read file", cA.length, 4, 0.000001); 
      Assert.assertEquals("Test read file2", iR.length, 5, 0.000001);
   }
   
   /**
    * Tests generateReport().
    * @throws FileNotFoundException if file not found  
    */
    
   @Test public void generateReportTest() throws FileNotFoundException {
      
      // String contained in Actual output
      String output = "Sapphire Cardholder\n";  
      output += "AcctNo/Name: 10001 Smith, Sam\n";
      output += "Previous Balance: $1,100.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $9.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,457.00\n";
      output += "Minimum Payment: $43.71\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_3_exceptions.txt");
   
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
      output += "Previous Balance: $1,100.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $9.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,457.00\n";
      output += "Minimum Payment: $43.71\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_3_exceptions.txt");
   
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
      output += "Previous Balance: $1,100.00\n";
      output += "Payment: ($200.00)\n";
      output += "Interest: $9.00\n";
      output += "New Purchases: $548.00\n";
      output += "Current Balance: $1,457.00\n";
      output += "Minimum Payment: $43.71\n";
      output += "Purchase Points: 548";
      
      // Ex. test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_3_exceptions.txt");
   
      // Test method
      Assert.assertEquals("GRCB test", true, 
         cP.generateReportByCurrentBalance().contains(output));
   }
   
   /**
    * Tests generateInvalidRecordsReport(). 
    * @throws FileNotFoundException if file not found
    */
   
   @Test public void generateInvalidRecordsReportTest() 
      throws FileNotFoundException {
   
   // String contained in actual output
   
      String output = "4;00000;Williams,Pat;1000.0;0.0;34.5;100.0;"
         + "63.50;300.0 *** invalid category ***";
   
   // Test processor with file read in
      CardholderProcessor cP = new CardholderProcessor();
      cP.readCardholderFile("cardholder_data_3_exceptions.txt");
   
   // Test method 
      Assert.assertTrue("GIRR Test", 
         cP.generateInvalidRecordsReport().contains(output)); 
   }
   
   /**
    * Tests Current Balance Comparator.
    * WAS TAKING .7 POINTS OFF MY PROJECT IF I DIDN'T!!!!
    * 
    * @param 
    */
    
   @Test public void compareTest() {
      
      // Create test CurrentBalanceComparator object 
      CurrentBalanceComparator i = new CurrentBalanceComparator();
      
      // Create test cardholder objects
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      
      SapphireCardholder sc2 = new SapphireCardholder("10004", "Smith, Jam"); 
      sc2.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc2.setPrevBalance(1200.0);
      sc2.setPayment(200);
   
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
   
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", 
         "King, Kelly"); 
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0); 
      bdc.setPrevBalance(1200.0);
      
      // Create cardholder Array 
      Cardholder[] cA = new Cardholder[3];
      cA[0] = sc;
      cA[1] = dc;
      cA[2] = bdc;
      Arrays.sort(cA, new CurrentBalanceComparator());
      
      // Test if Array is sorted by current balance
      Assert.assertEquals("Test", sc, cA[2]); // sc now equals cA[2]
      
      // Test compare method
      int t1 = i.compare(sc, dc);
      int t2 = i.compare(dc, sc);
      int t3 = i.compare(sc, sc2);
      
      Assert.assertEquals("CBC1 test", t1, 1, 0.000001);
      Assert.assertEquals("CBC2 test", t2, -1, 0.000001);
      Assert.assertEquals("CBC3 test", t3, 0, 0.000001);  
      
   }
}
