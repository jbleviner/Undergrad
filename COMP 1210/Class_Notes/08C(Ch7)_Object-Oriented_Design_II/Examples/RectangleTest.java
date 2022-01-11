import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RectangleTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test of the compareTo method. **/
   @Test public void compareToTest() {
   
      Rectangle r1 = new Rectangle(2, 5);
      Rectangle r2 = new Rectangle(2, 5);
      Rectangle r3 = new Rectangle(3, 6);
   
   
      Assert.assertTrue("compareTo equals test",
                         r1.compareTo(r2) == 0);
                           
      Assert.assertTrue("compareTo < test",
                         r1.compareTo(r3) < 0);
   
      Assert.assertTrue("compareTo > test",
                         r3.compareTo(r2) > 0);
                           
   }
   

   /** A test of the toString method. **/
   @Test public void toStringTest() {
   
      Rectangle r1 = new Rectangle(2, 5);
   
      Assert.assertTrue("toString test: ", r1.toString().contains("Rectangle Information:"));
   
   }
}
