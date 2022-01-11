
/**
* Shows differences between "int" and "Integer"
* variables. Also demos wrapper class methods. 
*/
public class AutoBoxingAndMethodsExamples {
  /**
   * Set a breakpoint on first executable
   * statement, then run Debug and examine variables 
   * as you step through main.
   *
   * @param args Command-line arguments (unused). 
   */
   public static void main(String[] args) {
      int i1 = 1; 
      int i2 = i1;
      int i3 = i2;
   
      Integer n1 = 1;
      Integer n2 = n1; 
      Integer n3 = n2;
   	
      i1 = 3;
      n1 = 3;
      
      i2 = new Integer(2);
      n2 = new Integer(2);
      
      i3 = i1 + n2;
      n3 = n1 + i2;
   	
      // find digits to left and right of decimal point in PI
      double x = Math.PI;
      Double y = x;
      String s = y.toString();
      String s2 = Double.toString(y); // a second way to convert
      
      int p = s.indexOf('.'); // locate decimal point in PI
      System.out.println("Digits to the left of decimal point in PI: "
                        + s.substring(0 , p));
      System.out.println("Digits to the right of decimal point in PI: "
                        + s.substring(p + 1, s.length()));
      
      // Print the max and min values for Integer and Double 
      // (these are also the max and min values for int and double)
      System.out.println("\nMax Integer: " + Integer.MAX_VALUE);
      System.out.println("Min Integer: " + Integer.MIN_VALUE);
      System.out.println("Max Double: " + Double.MAX_VALUE);
      System.out.println("Min Double: " + Double.MIN_VALUE);
      
      String s3 = "10";
      String s4 = "4.1";
      int j = Integer.parseInt(s3);
      double z = Double.parseDouble(s4);
      
      double product = j * z;
      System.out.println("\nProduct of \"10\" and \"4.1\" is: " + product);
     
   }
}
