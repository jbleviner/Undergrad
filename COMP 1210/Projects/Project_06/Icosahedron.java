import java.text.DecimalFormat;

/**
 * Program that defines and stores Icosahedron objects. 
 *    
 * Project 4/5/6
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version September 21st, 2018
 */

public class Icosahedron {

// ==================
// Instance Variables
// ==================

   private String label = "";
   private String color = "";
   private double edge = 0;
   
   // ===========
   // Constructor  
   // ===========
   
   /**
    * Constructor for Icosahedron object.
    *
    * @param labelIn label of the Icosahedron
    * @param colorIn color of the Icosahedron
    * @param edgeIn edge length of the Icosahedron
    */
   
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
   
   // =======
   // Methods 
   // =======
   
   /**
    * Method to get label.
    * 
    * @param
    * @return label returns label
    */
   
   public String getLabel() {
      return label;
   }
   
   /**
    * Method to set label.
    * 
    * @param labelIn label of the Icosahedron
    * @return true label is set if not null
    */
   
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      }
   }
   
   /**
    * Method to get color.
    *
    * @param
    * @return color returns color 
    */
   
   public String getColor() {
      return color;
   }
   
   /**
    * Method to set color.
    * 
    * @param colorIn color of Icosahedron
    * @return true color is set if not null
    */
   
   public boolean setColor(String colorIn) {
      if (colorIn == null) {
         return false;
      }
      else {
         color = colorIn.trim();
         return true;
      }
   }
   
   /**
    * Method to get edge length.
    * 
    * @param 
    * @return edge returns edge length
    */ 
   
   public double getEdge() {
      return edge;
   }
   
   /**
    * Method to set the edge length.
    *
    * @param edgeIn edge length of Icosahedron
    * @return true edge is set if not null 
    */  
   
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Method to calculate surface area. 
    * 
    * @param 
    * @return sA returns surface area 
    */
   
   public double surfaceArea() {
      double sA = 5 * (Math.sqrt(3) * Math.pow(edge, 2));
      return sA;
   }
   
   /**
    * Method to calculate volume. 
    *
    * @param 
    * @return v returns volume  
    */
   
   public double volume() {
      double v = ((5 * (3 + Math.sqrt(5))) / 12) * (Math.pow(edge, 3));
      return v; 
   }
   
   /**
    * Method to calculate the surface area to volume ratio.
    * 
    * @param 
    * @return ratio returns ratio  
    */
   
   public double surfaceToVolumeRatio() {
      double ratio = surfaceArea() / volume();
      return ratio;
   }
   
   // ============================================
   // Create string value for object 'Icosahedron'
   // ============================================
   
   /**
    * Method to create a string output.
    *
    * @param 
    * @return output returns output
    */  
   
   public String toString() {
      DecimalFormat form = new DecimalFormat("#,##0.0#####");
      String output = "Icosahedron \"" + label + "\" is \"" + color
         + "\" with 30 edges of length " + edge + " units." + "\n";
      output += "\tsurface area = " + form.format(surfaceArea())
         + " square units." + "\n";
      output += "\tvolume = " + form.format(volume()) + " cubic units." + "\n";
      output += "\tsurface/volume ratio = " 
         + form.format(surfaceToVolumeRatio());      
      return output;
   }  
}