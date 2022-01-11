/**
 * Represents a polygon with a specified number of sides
 * lengths. The polygon is classified based on its number of sides.
 */
public class Polygon 
{
   private double[] sideLengths;

   /**
    *  @param sidesIn array of side values
    *  @throws InvalidLengthException for side <= 0
    */
   public Polygon(double[] sidesIn) throws InvalidLengthException
   {
      for (double side : sidesIn) {
         if (side <= 0) {
            throw new InvalidLengthException(side);
         }
      }
      sideLengths = sidesIn; 
   }
   
   /**  
    *  @return sides array
    */
   public double[] getSides() {  
      return sideLengths;
   }

   /**  
    *  @return perimeter
    */
   public double calculatePerimeter() {
      double peri = 0;
   
      for (double length : sideLengths) {
         peri += length;
      }
   
      return peri;
   }

   /**  
    *  @param threshold for sides to return
    *  @return array of sides greater than threshold
    */
   public double[] getSidesGreaterThan(double threshold) {
      int count = 0;
      double[] sidesGreater;
      for (double length : sideLengths) {
         count = length > threshold ? count + 1 : count;
      }
   
      sidesGreater = new double[count];
   
      for (double length : sideLengths) {
         if (length > threshold) {
            sidesGreater[--count] = length;
         }
      }
   
      return sidesGreater;
   }

   /**  
    *  @return description of Polygon
    */
   public String toString() {
      switch (sideLengths.length) {
         case 0:
         case 1:
         case 2:
            return "non-polygon";
         case 3:
            return "triangle";
         case 4:
            return "rectangle";
         case 5:
            return "pentagon";
         case 6:
            return "hexagon";
         case 7:
            return "heptagon";
         case 8:
            return "octagon";
         default:
            return "n-gon";
      }
   }
}
