import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Test file for the TemperatureConverter class. */
public class TemperatureConverterTest {

   /**
    * Fixture initialization (common initialization
    * for all tests).
    */
   @Before public void setUp() {
   }

   /** Tests conversion from C to F. */
   @Test public void convertCelsiusToFarenTest1() {
      TemperatureConverter tc = new TemperatureConverter();
      Assert.assertEquals("Expected 32 F for 0 C.", 
                           32,
                           tc.convertToFarenheit(0),
                           0.000001);
   }
   
   /** Tests conversion from C to F. */
   @Test public void convertCelsiusToFarenTest2() {
      TemperatureConverter tc = new TemperatureConverter();
      Assert.assertEquals("Expected 32 F for 0 C.", 
                           212,
                           tc.convertToFarenheit(100),
                           0.000001);
   }

   /** Tests conversion from F to C. */
   @Test public void convertFarenToCelsiusTest1() {
      TemperatureConverter tc = new TemperatureConverter();
      Assert.assertEquals("Expected 0 C for 32 F.", 
                           0,
                           tc.convertToCelsius(32),
                           0.000001);
   }
    
   /** Tests conversion from F to C. */
   @Test public void convertFarenToCelsiusTest2() {
      TemperatureConverter tc = new TemperatureConverter();
      Assert.assertEquals("Expected 0 C for 32 F.", 
                           100,
                           tc.convertToCelsius(212),
                           0.000001);
   }

}
