import java.util.Scanner;

/**
 * Program to determine the midpoint of a line
      segment given the x and y coordinates for the 
      two end points of the line segment. 
 *
 * Project 2 
 * @author Kevin Bumgarner - COMP 1210 - 003
 * @version septemeber 4th, 2018
 */

public class MidpointOfLineSegment {

/**
  * Prompts user for endpoint 1 and 2, then prints midpoint. 
  * @param args Command line arguments - not used 
  */

   public static void main(String[] args) {
      
      Scanner uI = new Scanner(System.in);
      double x1 = 0;
      double x2 = 0;
      double y1 = 0;
      double y2 = 0;
      
      // Get cordinates for endpoint 1 from user.
      System.out.println("Enter the coordinates for endpoint 1:");
      System.out.print("\tx1 = ");
      x1 = uI.nextDouble();
      System.out.print("\ty1 = ");
      y1 = uI.nextDouble();
      
      // Get cordinates for endpoint 2 from user.
      System.out.println("Enter the coordinates for endpoint 2:");
      System.out.print("\tx2 = ");
      x2 = uI.nextDouble();
      System.out.print("\ty2 = ");
      y2 = uI.nextDouble();
      
      // Get equation for mid point.
      double midPointX = ((x1 + x2) / 2);
      double midPointY = ((y1 + y2) / 2);
   
      // Print mid point from users cordinates.
      System.out.println();
      System.out.print("For endpoints (" + x1 + ", " + y1 + ") and ("
         + x2 + ", " + y2 + "), the midpoint is (" 
         + midPointX + ", " + midPointY + ").");
      
   }
}