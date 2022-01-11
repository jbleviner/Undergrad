import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * Tests the main method of 'CardholdersPart2App'.
 *
 */ 


public class CardholdersPart2AppTest {


   /** Fixture initialization (common initialization
    *  for all tests). 
    */
    
   @Before public void setUp() {
   
   }
   
   /**
    * Tests main method without file input.
    *
    * @throws FileNotFoundException if file not found
    */
    
   @Test public void mainTest1() throws FileNotFoundException {
   
      // Exercise default constructor
      CardholdersPart2App app = new CardholdersPart2App();
    
      // Assign args to Empty String 
      String[] args1 = {};
      
      // Exercise main 
      CardholdersPart2App.main(args1);
      
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
      CardholdersPart2App app = new CardholdersPart2App();
    
      // Assign args to Empty String 
      String[] args2 = {"cardholder_data_1.txt"};
      
      // Exercise main 
      CardholdersPart2App.main(args2);
      
      // Run assertion
      Assert.assertEquals("Test IR variable", Cardholder.INTEREST_RATE, 
         0.01, 0.000001); 
   } 
}
