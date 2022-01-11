import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {

//////////////////
// CEILING TEST //
//////////////////

   @Test
   public void ceilingTest1() throws Exception {
      int[] a = {1,2,3,4};
      int key = 0; 
      int i = Selector.ceiling(a, key);
   }
}
