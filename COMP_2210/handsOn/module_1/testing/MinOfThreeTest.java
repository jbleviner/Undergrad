import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * MinOfThreeTest.java
 * Test Cases for methods of the MinOfThree Class.
 *
 * @author Kevin Bumgarner (kgb0022@auburn.edu)
 * @version 01-12-2020
 */



public class MinOfThreeTest {

   ///////////////////////
   // Typical Cases min1//
   ///////////////////////
   
   /* Test case for min1 */
   @Test
   public void testMin11() {
      int a = 2;
      int b = 1;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin12() {
      int a = 4;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   ///////////////////////
   // Typical Cases min2//
   ///////////////////////
   
   /* Test case for min2 */
   @Test
   public void testMin21() {
      int a = 2;
      int b = 1;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin22() {
      int a = 4;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /////////////////////////
   // Dupilcate Cases min1//
   /////////////////////////
   
   /* Test case for min1 */
   @Test
   public void testMin13() {
      int a = 2;
      int b = 2;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin14() {
      int a = 1;
      int b = 2;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin15() {
      int a = 2;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin16() {
      int a = 2;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin17() {
      int a = 3;
      int b = 2;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin18() {
      int a = 2;
      int b = 3;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min1 */
   @Test
   public void testMin19() {
      int a = 2;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min1(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /////////////////////////
   // Dupilcate Cases min2//
   /////////////////////////
   
   /* Test case for min2 */
   @Test
   public void testMin23() {
      int a = 2;
      int b = 2;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin24() {
      int a = 1;
      int b = 2;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin25() {
      int a = 2;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin26() {
      int a = 2;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin27() {
      int a = 3;
      int b = 2;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin28() {
      int a = 2;
      int b = 3;
      int c = 2;
      int expected = 2;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }
   
   /* Test case for min2 */
   @Test
   public void testMin29() {
      int a = 2;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min2(a,b,c);
      assertEquals(expected, actual);    
   }        
}
