package jgraspvex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryTreeTest {

   BinaryTree bt;


   /**
    * Fixture initialization (common initialization
    * for all tests).
    */
   @Before public void setUp() {
      bt = new BinaryTree();
   }


   @Test public void testAdd() {
      int size = bt.size();
      bt.add("test");
      Assert.assertTrue(bt.contains("test"));
      Assert.assertEquals(size + 1, bt.size());
   }


   @Test public void testRemove() {
      bt.add("test");
      int size = bt.size();
      bt.remove("test");
      Assert.assertFalse(bt.contains("test"));
      Assert.assertEquals(size - 1, bt.size());
   }


   @Test public void testContains() {
      bt.add("test");
      Assert.assertTrue(bt.contains("test"));
      bt.remove("test");
      Assert.assertFalse(bt.contains("test"));
   }


   @Test public void testClear() {
      bt.add("test");
      bt.clear();
      Assert.assertEquals(0, bt.size());
   }


   @Test public void testElements() {
      bt.clear();
      bt.add("b");
      bt.add("a");
      bt.add("c");
      Assert.assertArrayEquals(bt.elements(),
            new Comparable[] { "a", "b", "c" });
   }
}
