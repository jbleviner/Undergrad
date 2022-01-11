import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * Tests the methods of 'CardholdersPart3App.java'.
 *
 * Project 11
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 28th, 2018
 */


public class CardholdersPart3AppTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
    /**
    * Tests main method without file input.
    *
    * @throws FileNotFoundException if file not found
    */
    
   @Test public void mainTest1() throws FileNotFoundException {
   
      // Exercise default constructor
      CardholdersPart3App app = new CardholdersPart3App();
    
      // Assign args to Empty String 
      String[] args1 = {};
      
      // Exercise main 
      CardholdersPart3App.main(args1);
      
      // Run assertion 
      Assert.assertEquals("Test IR variable", Cardholder.INTEREST_RATE, 
         0.01, 0.000001); 
   }
   
    /**
    * Tests main method with file input.
    *
    * @throws FileNotFoundException if file not found
    */
    
   @Test public void mainTest2() throws FileNotFoundException {
      
      // Exercise default constructor
      CardholdersPart3App app = new CardholdersPart3App();
    
      // Assign args to Empty String 
      String[] args2 = {"cardholder_data_3_exceptions.txt"};
      
      // Exercise main 
      CardholdersPart3App.main(args2);
      
      // Run assertion
      Assert.assertEquals("Test IR variable", Cardholder.INTEREST_RATE, 
         0.01, 0.000001); 
   }
   
   /**
    * Tests the main method of 'CardholdersAppPart3'.
    *
    * @param 
    */
    
   @Test public void mainTest3() {          
      
      // Exercise default constructor 
      CardholdersPart3App app = new CardholdersPart3App();
      
      // Assign args to non existing file
      String[] args3 = {"nofile.txt"};
      
      // Exercise main 
      CardholdersPart3App.main(args3);
      
      // Run asserstion 
      Assert.assertEquals("Test IR value", Cardholder.INTEREST_RATE,
            0.01, 0.000001);
   }
}