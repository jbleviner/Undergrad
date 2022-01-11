package jgraspvex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryTreeTest2 {

   BinaryTree bt;


   /**
    * Fixture initialization (common initialization
    * for all tests).
    */
   @Before public void setUp() {
      bt = new BinaryTree();
   }


   @Test public void test() {
      String[] elements = { "A", "D", "C", "Ant",
            "Car", "Test" };
      bt.clear();
      for (String s : elements) {
         bt.add(s);
      }
      Assert.assertEquals(elements.length, bt.size());
      for (String s : elements) {
         bt.remove(s);
      }
      Assert.assertEquals(0, bt.size());
   }
}
