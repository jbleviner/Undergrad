import java.text.DecimalFormat;
/**
 * A program to define instance variables for the radius, height and label
 * of a cone and calculate the following measurements usig seperate methods
 * that will be applied using another main program.
 *
 * Project 4.
 * @author Austin Smith
 * @version 2/12/21
 */
public class Cone {
   private String label = "";
   private double height = 0;
   private double radius = 0;
   //Constructor
   /**
    * Create a constructor to outline the needed information.
    * @param radiusIn radius of the cone
    * @param heightIn height of the cone
    * @param labelIn the label of the cone
    */

   public Cone(String labelIn, double heightIn, double radiusIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
   }
   //Methods
   /**
    * Get the label.
    * @return String label
    */
   public String getLabel()
   {
      return label;
   }
   /**
    * Get the radius.
    * @return double radius
    */

   public double getRadius()
   {
      return radius;
   }
   
   /**
    * Get the height.
    * @return double height
    */

   public double getHeight()
   {
      return height;
   }
   /**
    * Set the label.
    * @param labelIn label
    * @return if the variable has been created
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
    * Set the height.
    * @param heightIn height
    * @return if height has been set
    */

   public boolean setHeight(double heightIn) {
      if (heightIn > 0) {
         height = heightIn;
         return true;
      }
      else {
         return false;
      }
   }
   /**
    * Set the radius.
    * @param radiusIn radius
    * @return if radius has been set
    */

   public boolean setRadius(double radiusIn) {
      if (radiusIn > 0) {
         radius = radiusIn;
         return true;
      }
      else {
         return false;
      }
   }
  
   /**
    * Solve for the perimeter.
    * @return perimeter
    */

   public double basePerimeter()
   {
      double perimeter = 2 * Math.PI * radius;
      return perimeter;
   }
   /**
    * Solve for the base area.
    * @return area
    */

   public double baseArea()
   {
      double area = Math.PI * Math.pow(radius, 2);
      return area;
   }
   /**
    * Solve for the slant height.
    * @return slant
    */

   public double slantHeight()
   {
      double slant = Math.sqrt(Math.pow(radius, 2) 
         + Math.pow(height, 2));
      return slant;
   }
   /**
    * Solve for the side area.
    * @return sideArea
    */

   public double sideArea()
   {
      double sideArea = Math.PI * radius * slantHeight();
      return sideArea;
   }
   /**
    * Solve for the surface area.
    * @return sArea
    */

   public double surfaceArea()
   {
      double sArea = Math.PI * radius * (radius + slantHeight());
      return sArea;
   }
   /**
    * Solve for the volume.
    * @return volume
    */

   public double volume()
   {
      double volume = (Math.PI * Math.pow(radius, 2) * height) / 3;
      return volume;
   }
   /**
    * Convert the following expression into a string.
    * @return result
    */

   public String toString()
   {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "\"" + label + "\"" + " is a cone with height = "
         + df.format(height) + " units and radius = "
         + df.format(radius)
         + " units," + "\nwhich has base perimeter = " 
         + df.format(basePerimeter()) + " units, base area = "
         + df.format(baseArea()) + " square units,\n" 
         + "slant height = " + df.format(slantHeight()) + " units, side area"
         + " = " + df.format(sideArea()) + " square units," + "\n"
         + "surface area = " + df.format(surfaceArea()) + " square units, and"
         + " volume = " + df.format(volume()) + " cubic units.";
      return output;
   }
}