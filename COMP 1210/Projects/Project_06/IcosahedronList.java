import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program that creates an IcosahedronLists and contains methods to 
 * alter that list. 
 * 
 * Project 5/6
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 10th, 2018
 */

public class IcosahedronList {

// ============================================================
// Fields
// ============================================================

   private String listName = "";
   private ArrayList<Icosahedron> iList;
   
   // =========================================================
   // Constructor
   // =========================================================
   
   /**
    * Constructor that defines ArrayList objects of Icosahedron type.
    * 
    * @param listNameIn the name of the list
    * @param iListIn the ArrayList of Icosahedron Objects 
    */
   
   public IcosahedronList(String listNameIn, ArrayList<Icosahedron> iListIn) {
      listName = listNameIn;
      iList = iListIn;
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
    * Method to get size of list.
    *
    * @param
    * @return iList.size() size of list
    */
   
   public int numberOfIcosahedrons() {
      return iList.size();
   }
   
   /**
    * Method to get total surface area.
    *
    * @param
    * @return totalSA total surface area 
    */
   
   public double totalSurfaceArea() {
   
      int numI = 0;
      double totalSA = 0;
   
      while (numI < numberOfIcosahedrons()) {
         totalSA += iList.get(numI).surfaceArea();
      
         numI++;
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
   
      int numI = 0;
      double totalV = 0;
   
      while (numI < numberOfIcosahedrons()) {
         totalV += iList.get(numI).volume();
         numI++;
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
   
      int numI = 0;
      double totalAA = 0;
   
      if (numI < numberOfIcosahedrons()) {
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
      int numI = 0;
      double totalAV = 0;
   
      if (numI < numberOfIcosahedrons()) {
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
      int numI = 0;
      
      while (numI < numberOfIcosahedrons()) {
         totalR += iList.get(numI).surfaceToVolumeRatio() 
                                          / numberOfIcosahedrons();
         numI++;
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
      int numI = 0;
      while (numI < numberOfIcosahedrons()) {
         result += "\n" + iList.get(numI) + "\n"; 
         numI++;  
      }   
      return result;
    
   }
   
   /**
    * Method to return a String value that 
    * summarizes the list of icosahedrons.
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
   // Updated for Project 06
   // =============================================================
   
   /**
    * Mthod to return an Array List.
    *
    * @param
    * @return iList ArrayList 
    */
   public ArrayList<Icosahedron> getList() {
      return iList;
   }
   
   /**
    * Method to read in a File.
    *
    * @param fileIn file read in
    * @return myList List of Icosahedrons
    * @throws FileNotFoundException if file is not found
    */
   
   public static IcosahedronList readFile(String fileIn) 
      throws FileNotFoundException {
      
      ArrayList<Icosahedron> icoList = new ArrayList<Icosahedron>();
      String iListName = "";
      String label = "";
      String color = "";
      double edge = 0;
   
      Scanner scanFile = new Scanner(new File(fileIn));
      iListName = scanFile.nextLine();
      
      // Read file and add Ico objects to an ArrayList
   
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
      
         Icosahedron icoObj = new Icosahedron(label, color, edge);
         icoList.add(icoObj);
      }
      
      scanFile.close();
   
      IcosahedronList myList = new IcosahedronList(iListName, icoList);
      
      // return list of Icosahedrons
   
      return myList;
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
      iList.add(addedIco);
   }
   
   /** 
    * Method to find Icosahedron.
    *
    * @param labelIn label
    * @return null if not found  
    */ 
   
   public Icosahedron findIcosahedron(String labelIn) {
      
      boolean result = false;
      for (Icosahedron iObj : iList) {
         
         if (iObj.getLabel().equalsIgnoreCase(labelIn)) {
            
            return iObj;
         }
      }
   
      return null;
   }
   
   /**
    * Method to delete an Ico.
    *
    * @param labelIn label
    * @return result deleted Ico object
    */
   
   public Icosahedron deleteIcosahedron(String labelIn) {
      
      int i = iList.indexOf(findIcosahedron(labelIn));
      
      
      if (i >= 0) {
      
         return iList.remove(i);
         
      
      }
      
      return null;
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
   
      for (Icosahedron iObj : iList) {
         
         if (iObj.getLabel().equalsIgnoreCase(labelIn)) {
            iObj.setColor(colorIn);
            iObj.setEdge(edgeIn);
            result = true;
            
            break;
         }
      
      }
   
      return result;
   } 
   
}