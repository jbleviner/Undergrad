import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program that creates an Icosahedron Array and contains methods to 
 * alter that Array. 
 * 
 * Project 5/6/7/8B
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 18th, 2018
 */

public class IcosahedronList2 {

// ============================================================
// Fields
// ============================================================

   private String listName = "";
   private Icosahedron[] icoArray;
   private int icoCount;
   
   
   
   // =========================================================
   // Constructor
   // =========================================================
   
   /**
    * Constructor that defines ArrayList objects of Icosahedron type.
    * 
    * @param listNameIn the name of the list
    * @param icoArrayIn the Array of Icosahedron Objects
    * @param icoCountIn the number of Icosahedrons  
    */
   
   public IcosahedronList2(String listNameIn, 
                              Icosahedron[] icoArrayIn, int icoCountIn) {
      listName = listNameIn;
      icoArray = icoArrayIn;
      icoCount = icoCountIn;
   }
   
   // =========================================================
   // Methods
   // =========================================================
   
   /**
    * Method to get list name.
    *
    * @param 
    * @return listName name of list.
    */
   
   public String getName() {
      return listName;
   }
   
   /**
    * Method to get size of the Array.
    *
    * @param
    * @return icoCount size of Array
    */
   
   public int numberOfIcosahedrons() {
   
      /**
      for (int i = 0; i < icoCount; i++) {
         if (icoArray[i] == null) {
            icoCount--;
         }
      }
      */
      
      // Simplified, Project 08B
      return icoCount;
   }
   
   
   /**
    * Method to get total surface area.
    *
    * @param
    * @return totalSA total surface area 
    */
   
   public double totalSurfaceArea() {
   
      int index = 0;
      double totalSA = 0;
   
      while (index < numberOfIcosahedrons()) {
         totalSA += icoArray[index].surfaceArea();
      
         index++;
      }
   
      return totalSA;
   }
   
   /**
    * Method to get total volume.
    *
    * @param 
    * @return totalV total volume 
    */
   
   public double totalVolume() {
   
      int index = 0;
      double totalV = 0;
   
      while (index < numberOfIcosahedrons()) {
         totalV += icoArray[index].volume();
         index++;
      }
   
      return totalV;
   }
   
   /**
    * Method to get average surface area.
    *
    * @param
    * @return totalAA total average surface area 
    */
   
   public double averageSurfaceArea() {
   
      int index = 0;
      double totalAA = 0;
   
      if (index < numberOfIcosahedrons()) {
         totalAA = totalSurfaceArea() / numberOfIcosahedrons();
      }
      return totalAA;
   }
   
   /**
    * Method to find average volume.  
    * 
    * @param  
    * @return totalAV total average volume  
    */
   
   public double averageVolume() {
      int index = 0;
      double totalAV = 0;
   
      if (index < numberOfIcosahedrons()) {
         totalAV = totalVolume() / numberOfIcosahedrons(); 
      }
    
      return totalAV;
   }
   
   /**
    * Method to get average surface to volume ratio.
    *
    * @param 
    * @return totalR average surface to volume ratio
    */
   
   public double averageSurfaceToVolumeRatio() {
   
      double totalR = 0;
      int index = 0;
      
      while (index < numberOfIcosahedrons()) {
         totalR += icoArray[index].surfaceToVolumeRatio() 
                                          / numberOfIcosahedrons();
         index++;
      }
      
      return totalR;   
   }
   
   /**
    * Method to return list of Icosahedrons.
    *
    * @param
    * @return result list of icosahedrons
    */
   
   public String toString() {
   
      String result = listName + "\n";
      int index = 0;
      while (index < numberOfIcosahedrons()) {
         result += "\n" + icoArray[index] + "\n"; 
         index++;  
      }   
      return result;
    
   }
   
   /**
    * Method to return a String value that 
    * summarizes the Array of icosahedrons.
    * 
    * @param
    * @return result summary of list 
    */
   
   public String summaryInfo() {
      int numI = 0;
      
     
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----";
      result += "\nNumber of Icosahedrons: " + numberOfIcosahedrons();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
      result += "\nTotal Volume: " + df.format(totalVolume());
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      result += "\nAverage Surface/Volume Ratio: " 
            + df.format(averageSurfaceToVolumeRatio()) + "\n";
            
         
      return result;
   }
   
   // =============================================================
   // Begin new methods 
   // =============================================================
   
   /**
    * Method to return an Array.
    *
    * @param
    * @return icoArray Array 
    */
    
   public Icosahedron[] getList() {
      return icoArray;
   }
   
   /**
    * Method to read in a File.
    *
    * @param fileIn file read in
    * @return myList List of Icosahedrons
    * @throws FileNotFoundException if file is not found
    */
    
   public IcosahedronList2 readFile(String fileIn) 
      throws FileNotFoundException {
      
      Scanner scanFile = new Scanner(new File(fileIn));
      Icosahedron[] myList = new Icosahedron[20];
      String iListName = "";
      int numIcosahedrons = 0;
      String label = "";
      String color = "";
      double edge = 0;
      
      listName = scanFile.nextLine();      
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Icosahedron i = new Icosahedron(label, color, edge);
         myList[numIcosahedrons] = i;
         numIcosahedrons++;
                    
      }
      
      IcosahedronList2 iL = new IcosahedronList2(listName, 
                                                  myList, numIcosahedrons);
      return iL;
      
   }
   
   /**
    * Method to add an Ico to the list.
    *
    * @param labelIn label
    * @param colorIn color
    * @param edgeIn edge 
    */
    
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      
      Icosahedron addedIco = new Icosahedron(labelIn, colorIn, edgeIn);
      icoArray[icoCount] = addedIco;
      icoCount++;
   }
   
   /** 
    * Method to find Icosahedron.
    *
    * @param labelIn label
    * @return null if not found  
    */
     
   public Icosahedron findIcosahedron(String labelIn) {
   
      if (icoCount > 0) {
      
         for (int i = 0; i < icoCount; i++) {
            
            if (icoArray[i].getLabel().equalsIgnoreCase(labelIn)) {
               return icoArray[i];
            }
         
         }
         
         return null;
      } 
         
      else {
         return null;
      }
   
   }
   
   /**
    * Method to delete an Ico.
    *
    * @param labelIn label
    * @return icoArray2[0] deleted Ico object
    */
    
   public Icosahedron deleteIcosahedron(String labelIn) {
   
      Icosahedron[] icoArray2 = new Icosahedron[1];
      
      for (int i = 0; i < icoCount; i++) {
         
         if (icoArray[i].getLabel().equalsIgnoreCase(labelIn)) {
            icoArray2[0] = findIcosahedron(labelIn);
            
            for (int j = i; j < icoCount - 1; j++) {
               icoArray[j] = icoArray[j + 1];
            }
            
            icoArray[icoCount - 1] = null;
            icoCount--;
         }
      }
      
      return icoArray2[0];
   }
   
   /**
    * Method to edit Icosahedron.
    *
    * @param labelIn label
    * @param colorIn color
    * @param edgeIn edge
    * @return result new Ico object
    */
    
   public boolean editIcosahedron(String labelIn, 
      String colorIn, double edgeIn) { 
   
      
      boolean result = false;
      
      
      for (int i = 0; i < icoCount; i++) {
         
         if (icoArray[i].getLabel().equalsIgnoreCase(labelIn)) {
            icoArray[i].setColor(colorIn);
            icoArray[i].setEdge(edgeIn);
            result = true;
            
         }
       // Removed 'break', Project 08B  
      }
      
      return result;
   } 
   
   // ======================================================
   // New methods for Project 08B
   // ======================================================
   
   /**
    * Finds Ico with shortest edge length.
    *
    * @param 
    * @return null returns null if no Ico's are found 
    */
    
   public Icosahedron findIcosahedronWithShortestEdge() {
      
      Icosahedron shortEdge = null;
      
      // Iterate through icoArray
      for (int i = icoCount - 1; i >= 0; i--) {
         
         double edgeLength = icoArray[0].getEdge();
         
         if (edgeLength >= icoArray[i].getEdge()) {
            edgeLength = icoArray[i].getEdge();
            shortEdge = icoArray[i];
         }
         
      }
      
      return shortEdge;
   }
   
   /**
    * Finds Ico with longest edge length.
    *
    * @param 
    * @return null returns null if no Ico's are found 
    */
   
   public Icosahedron findIcosahedronWithLongestEdge() {
      
      Icosahedron longEdge = null;
      
      // Iterate through icoArray
      for (int i = 0; i < icoCount; i++) {
         
         double edgeLength = icoArray[0].getEdge();
         
         if (edgeLength < icoArray[i].getEdge()) {
            edgeLength = icoArray[i].getEdge();
            longEdge = icoArray[i];
         }
         
      }
      
      return longEdge;
   }
   
   /**
    * Finds Ico with the smallest volume.
    *
    * @param 
    * @return null returns null if no Ico's are found 
    */
   
   public Icosahedron findIcosahedronWithSmallestVolume() {
        
      Icosahedron smallV = null;
      
      // Iterate through icoArray
      for (int i = 0; i < icoCount; i++) {
         
         double v = icoArray[0].volume();
         
         if (v >= icoArray[i].volume()) {
            v = icoArray[i].volume();
            smallV = icoArray[i];
         }
         
      }
      
      return smallV;
   }
   
   /**
    * Finds Ico with the largest Volume.
    *
    * @param 
    * @return null returns null if no Ico's are found 
    */
   
   public Icosahedron findIcosahedronWithLargestVolume() {
   
      Icosahedron bigV = null;
      
      // Iterate through icoArray
      for (int i = 0; i < icoCount; i++) {
         
         double v = icoArray[0].volume();
         
         if (v < icoArray[i].volume()) {
            v = icoArray[i].volume();
            bigV = icoArray[i];
         }
         
      }
      
      return bigV;
   } 
}