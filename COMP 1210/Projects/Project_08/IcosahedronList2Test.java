import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//import java.io.File;
import java.io.FileNotFoundException;


/**
 * Program to test the methods of 'IcosahedronList2.java'.
 *
 *
 * Project 08B
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 30th, 2018
 *
 */
 
public class IcosahedronList2Test {

 

   /** Fixture initialization (common initialization
    *  for all tests). **/
   
   @Before public void setUp() {
   }

   /**
    * Tests the getters of 'IcosahedronList2.java'.
    *
    */

   @Test public void getNameTest() {
   
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("getName test", "Test List", 
         iList.getName());
         
   }
   
   /**
    * Tests the numberOfIcosahedrons method.
    *
    */
  
   @Test public void numberOfIcosahedronsTest() {
   
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("num of Icos test", 3, 
         iList.numberOfIcosahedrons(), 0.000001);       
   }
   
   /**
    * Tests the totalSurfaceArea method. 
    *
    */
  
   @Test public void totalSurfaceAreaTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("total surface area test", 133184.749,
         iList.totalSurfaceArea(), 0.001); 
   }
   
   /**
    * Tests the totalVolume method.
    *
    */
    
   @Test public void totalVolumeTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("total volume test", 4103641.239,
         iList.totalVolume(), 0.001);
   }
   
   /**
    * Tests the averageSurfaceArea method.
    *
    */
  
   @Test public void averageSurfaceAreaTest() {
   
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("average SA test", 44394.916,
         iList.averageSurfaceArea(), 0.001);
         
      // Test method if no Ico's exist   
      IcosahedronList2 iL = new IcosahedronList2("Test List", iArray, 0);
      Assert.assertEquals("average SA test", 0,
         iL.averageSurfaceArea(), 0.000001);
   }
   
   /**
    * Tests the averageVolume method. 
    *
    */
    
   @Test public void averageVolumeTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("average volume test", 1367880.413,
         iList.averageVolume(), 0.001);
      
      // Test method if no Ico's exist   
      IcosahedronList2 iL = new IcosahedronList2("Test List", iArray, 0);
      Assert.assertEquals("average volume test", 0,
         iL.averageVolume(), 0.000001);
   }
   
   /**
    * Tests the averageSurfaceToVolumeRatio method. 
    *
    */
  
   @Test public void averageSurfaceToVolumeRatioTest() {
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("average SVR test", 132.435,
         iList.averageSurfaceToVolumeRatio(), 0.001);
         
   }
   
   /**
    * Tests the toString method.
    *
    */
   
   @Test public void toStringTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      String f = "Test List\n"
         + "\nIcosahedron \"" + "Small" + "\" is \"" + "blue"
         + "\" with 30 edges of length " + "0.01" + " units." + "\n"
         + "\tsurface area = 0.000866 square units.\n"
         + "\tvolume = 0.000002 cubic units.\n"
         + "\tsurface/volume ratio = 396.950723\n"
         + "\n"
         + "Icosahedron \"" + "Medium" + "\" is \"" + "orange"
         + "\" with 30 edges of length " + "12.3" + " units." + "\n"
         + "\tsurface area = 1,310.209833 square units.\n"
         + "\tvolume = 4,059.844212 cubic units.\n"
         + "\tsurface/volume ratio = 0.322724\n"
         + "\n"
         + "Icosahedron \"" + "Large" + "\" is \"" + "white"
         + "\" with 30 edges of length " + "123.4" + " units." + "\n"
         + "\tsurface area = 131,874.537977 square units.\n"
         + "\tvolume = 4,099,581.395236 cubic units.\n"
         + "\tsurface/volume ratio = 0.032168";
         
      Assert.assertEquals("toString test", true, iList.toString().contains(f));
         
   }
   
   /**
    * Tests the summaryInfo method.
    *
    */
    
   @Test public void summaryInfoTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
     
      String s = "----- Summary for Test List -----\n"
         + "Number of Icosahedrons: 3\n"
         + "Total Surface Area: 133,184.749\n"
         + "Total Volume: 4,103,641.239\n"
         + "Average Surface Area: 44,394.916\n"
         + "Average Volume: 1,367,880.413\n"
         + "Average Surface/Volume Ratio: 132.435";
         
      Assert.assertEquals("summaryInfo test", true,
         iList.summaryInfo().contains(s)); 
      
   }
   
   /**
    * Tests the readFile method.
    * @throws FileNotFoundException if not found 
    */
   
   @Test public void readFileTest() throws FileNotFoundException {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", null, 0);
      // Read file and check if exists 
      iList = iList.readFile("icosahedron_data_1.txt");
      Assert.assertEquals("readFile Test",
                           "Icosahedron Test List", iList.getName());
   }
   
   /**
    * Tests the addIcosahedron method.
    *
    */
   
   @Test public void addIcosahedronTest() {
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      // Create new Ico and add to iList
      Icosahedron i = new Icosahedron("huge", "purple", 10.5);
      // Tests getList()
      Icosahedron[] iA = iList.getList();
      iList.addIcosahedron("huge", "purple", 10.5);
      
      Assert.assertEquals("add Ico test", i, iA[3]);
   }
   
   /**
    * Tests the findIcosahedron method.
    *
    */
   
   @Test public void findIcosahedronTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
        
        // if found
      Assert.assertEquals("find ico test", iArray[2],
         iList.findIcosahedron("Large"));
        
        // if not found
      Assert.assertEquals("find ico test", null,
         iList.findIcosahedron("huge"));
         
        // if count is 0
      IcosahedronList2 iL = new IcosahedronList2("Test List", iArray, 0);
      Assert.assertEquals("find Ico test", null,
         iL.findIcosahedron("Large"));
   }
   
   /**
    * Tests the deleteIcosahedron method.
    *
    */
    
   @Test public void deleteIcosahedronTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Icosahedron i = new Icosahedron("Medium", "orange", 12.3);
      // Tests getList()
      Icosahedron[] iA = iList.getList();
      
      // Test iA
      Assert.assertEquals("before delete", i, iA[1]);
      // Test deleteIcosahedron
      iList.deleteIcosahedron("Small");
      Assert.assertEquals("delete Ico test", i, iA[0]);
      // Test if Ico not found 
      Assert.assertEquals("not found test", null,
         iList.deleteIcosahedron("huge"));
     
   }
   
   /**
    * Tests the editIcosahedron method.
    *
    */
    
   @Test public void editIcosahedronTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      // Test if true  
      Assert.assertTrue("edit ico test", 
         iList.editIcosahedron("Large", "red", 10.5));
      // Test equalsIgnoreCase  
      Assert.assertEquals("edit Ico test", true,
         iList.editIcosahedron("meDIuM", "green", 5));
      // Test for false
      Assert.assertEquals("edit Ico Test", false,
         iList.editIcosahedron("huge", "green", 12.3));
   }
   
   // =======================================================
   // Project 08B Method Tests
   // =======================================================
   
   /**
    * Test the findIcosahedronWithShortestEdge method.
    *
    */
    
   @Test public void findIcosahedronWithShortestEdgeTest() {
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("shortest edge test", 
         iArray[0], iList.findIcosahedronWithShortestEdge());
      
      // KEEPS COUNTING ALL ICOS
      Icosahedron.resetCount();
   }
   
   /**
    * Test findIcosahedronWithLongestEdge method. 
    *
    */
   
   @Test public void findIcosahedronWithLongestEdgeTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("longest edge test", 
         iArray[2], iList.findIcosahedronWithLongestEdge());
         
      // KEEPS COUNTING ALL ICOS
      Icosahedron.resetCount();
   }
   
   /**
    * Tests the findIcosahedronWithSmallestVolume method.
    *
    */
   
   @Test public void findIcosahedronWithSmallestVolumeTest() {
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("smallest volume test", 
         iArray[0], iList.findIcosahedronWithSmallestVolume());
      
      // KEEPS COUNTING ALL ICOS
      Icosahedron.resetCount();
   }
   
   /**
    * Tests the findIcosahedronWithLargestVolume method.
    *
    */
   
   @Test public void findIcosahedronWithLargestVolumeTest() {
      
      // Test Array
      Icosahedron[] iArray = new Icosahedron[20];
      iArray[0] = new Icosahedron("Small", "blue", 0.01);
      iArray[1] = new Icosahedron("Medium", "orange", 12.3);
      iArray[2] = new Icosahedron("Large", "white", 123.4);
      
      // Test List
      IcosahedronList2 iList = new IcosahedronList2("Test List", iArray, 3);
      
      Assert.assertEquals("largest volume test", 
         iArray[2], iList.findIcosahedronWithLargestVolume());
      
      // KEEPS COUNTING ALL ICOS
      Icosahedron.resetCount();
   }
   
}

