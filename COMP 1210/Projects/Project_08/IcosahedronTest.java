import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** 
 * Tests the methods of the Icosahedron class.
 *
 * Project 08A/08B
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 23rd, 2018
 */

public class IcosahedronTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   
   @Before public void setUp() {
   }

   /**
    * Tests getters of the Icosahedron class.
    *
    *
    */
   
   @Test public void gettersAndResetTest() {
   
      Icosahedron i = new Icosahedron("Small", "blue", 1);
   
      // Test get Label, color, edge 
      Assert.assertEquals("getLabel() test", "Small", i.getLabel());
      Assert.assertEquals("getColor() test", "blue", i.getColor());
      Assert.assertEquals("getEdge() test", 1, i.getEdge(), .000001);
      
      // Test getCount()
      Assert.assertEquals("getCount() test", 1, 
         Icosahedron.getCount(), .000001);
      
      // Test resetCount()
      Icosahedron.resetCount();
      Assert.assertEquals("resetCount() test", 0, 
         Icosahedron.getCount(), .000001);
   }
   
   /** 
    * Tests the setters of the Icosahedron class.
    *
    *
    */
   
   @Test public void settersTest() {
   
      Icosahedron i = new Icosahedron("Small", "blue", 1);
   
      // Test setLabel()
      Assert.assertEquals("setLabel() test", true, i.setLabel("Small"));
      Assert.assertEquals("setLabel() test", false, i.setLabel(null));
      
      // Test setColor
      Assert.assertEquals("setColor() test", true, i.setColor("blue"));
      Assert.assertEquals("setColor() test", false, i.setColor(null));
      
      // Test setEdge
      Assert.assertEquals("setEdge() test", true, i.setEdge(1));
      Assert.assertEquals("setEdge() test", false, i.setEdge(0));
      
   }
   
   /**
    * Tests the surfaceArea method of the Icosahedron class.
    *
    *
    */
   
   @Test public void surfaceAreaTest() {
   
      Icosahedron i = new Icosahedron("Small", "blue", 1);
   
      Assert.assertEquals("surfaceArea() test", 8.660254, 
         i.surfaceArea(), .000001);
   }
   
   /**
    * Tests the volume method of the Icosahedron class.
    *
    *
    */
    
   @Test public void volumeTest() {
   
      Icosahedron i = new Icosahedron("Small", "blue", 1);
   
      Assert.assertEquals("volume() test", 2.181695, 
         i.volume(), .000001);
   }
   
   /**
    * Tests the surfaceToVolumeRatio method of the Icosahedron class.
    *
    *
    */
    
   @Test public void surfaceToVolumeRatioTest() {
   
      Icosahedron i = new Icosahedron("Small", "blue", 1);
   
      Assert.assertEquals("surfaceToVolumeRatio() test", 3.969507, 
         i.surfaceToVolumeRatio(), .000001);
   }
   
   /**
    * Tests the toString method of the Icosahedron class.
    *
    *
    */
    
   @Test public void toStringTest() {
      
      Icosahedron i = new Icosahedron("small", "blue", 1);
   
      String f = "Icosahedron \"" + "small" + "\" is \"" + "blue"
         + "\" with 30 edges of length " + "1.0" + " units." + "\n"
         + "\tsurface area = 8.660254 square units.\n"
         + "\tvolume = 2.181695 cubic units.\n"
         + "\tsurface/volume ratio = 3.969507";
         
      Assert.assertEquals("toString() test", true, i.toString().contains(f));   
   }
   
   /**
    * Tests the equals method of the Icosahedron class.
    *
    *
    */
   
   @Test public void equalsTest() {
      
      // Create one Stirng obj and Ico objs (2 equal, 3 don't)
      String s = "";
      Icosahedron i = new Icosahedron("small", "blue", 1);
      Icosahedron z = new Icosahedron("small", "blue", 1);
      Icosahedron k = new Icosahedron("small", "blue", 2);
      Icosahedron l = new Icosahedron("small", "red", 1);
      Icosahedron t = new Icosahedron("large", "blue", 1);
      
      // Test true and false for equals()
      
      // Check if i equals z
      Assert.assertEquals("equals() test", true, i.equals(z));
      // Check if s is an instance of Icosahedron
      Assert.assertEquals("equals() test", false, i.equals(s));
      // Check if Icosahedrons don't equal eachother (i vs. k, l, t)
      Assert.assertEquals("equals() test", false, i.equals(k));
      Assert.assertEquals("equals() test", false, i.equals(l));
      Assert.assertEquals("equals() test", false, i.equals(t));
   }
   
   /**
    * Tests the hashCode method of the ICosahedron class.
    *
    *
    */
   
   
   @Test public void hashCodeTest() {
      
      Icosahedron i = new Icosahedron("small", "blue", 1);
      
      Assert.assertEquals("hashCode() test", 0, i.hashCode(), .000001);
   } 
}

