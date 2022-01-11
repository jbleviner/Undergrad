import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ArraySumTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   
   @Test 
   public void test1() {
      int[] a = {1, 3, 2, 4};
      int expected = 10;
      int actual = ArraySum.sum(a, 0, a.length - 1);
      Assert.assertEquals("", expected, actual);
   }
}
