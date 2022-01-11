import java.util.Scanner;

/**
 * Program with a main method that calls on methods 
 *    from 'Icosahedron.java' to create 
 *    an Icosahedron object and then print it. 
 * 
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version September 21st, 2018
 */

public class IcosahedronApp {

/**
 * Creates an object then prints it.
 *
 * @param args Command line arguments - not used 
 */
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String userLabel;
      String userColor;
      double userEdge;
      
      // ======================================
      // Prompt user for label, color, and edge
      // ======================================
      
      System.out.println("Enter label, color, and"
         + " edge length for an icosahedron.");
      System.out.print("\tlabel: ");
      userLabel = input.nextLine();
      System.out.print("\tcolor: ");
      userColor = input.nextLine();
      System.out.print("\tedge: ");
      userEdge = Double.parseDouble(input.nextLine());
      
      // =====================================================================
      // End process if edge isn't greater than 0 or create Icosahedron object
      // =====================================================================
      
      if (userEdge <= 0) {
         System.out.println("Error: edge must be greater than 0.");
      }
      else {
         Icosahedron i = new Icosahedron(userLabel, userColor, userEdge);
         System.out.print("\n" + i);
      }
      
   }
}