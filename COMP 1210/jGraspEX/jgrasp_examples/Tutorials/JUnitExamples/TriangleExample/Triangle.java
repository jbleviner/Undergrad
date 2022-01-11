
/** Determines if three doubles can be sides of triangle. */
public class Triangle  {

   /** Length of side 1. */
   private double a;

   /** Length of side 2. */
   private double b;

   /** Length of side 3. */
   private double c;

   /**
    * Creates a Triangle.
    *
    * @param aIn length of side 1.
    *
    * @param bIn length of side 2.
    *
    * @param cIn length of side 3.
    */
   public Triangle(double aIn, double bIn, double cIn) {
      a = aIn;
      b = bIn;
      c = cIn;
      if (a <= 0 || b <= 0 || c <= 0) {
         throw new IllegalArgumentException("Sides: " + a + " " + b
            + " " + c
            + " -- each must be greater than zero.");
      }
      if ((a >= b + c) || (b >= a + c) || (c >= a + b)) {
         throw new IllegalArgumentException("Sides: "
            + a + " " + b + " " + c
            + " -- not a triangle.");
      }
   }

   /**
    * Classifies a triangle based on the lengths of the three sides.
    *
    * @return the triangle classification.
    */
   public String classify() {
      String result;
      if ((a == b) && (b == c)) {
         result = "equilateral";
      }
      else if ((a != b) && (a != c) && (b != c)) {
         result = "scalene";
      }
      else {
         result = "isosceles";
      }
   
      return result;
   }

}
