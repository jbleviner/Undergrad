import java.util.Scanner;
/**
 * A program to print the certain measurements of a cone given the height and
 * radius of it using an instance from the Cone program.
 *
 * Project 4.
 * @author Austin Smith
 * @version 2/12/21
 */

public class ConeApp {
   /**
    * Invoke methods on an instance of Cone.
    * @param args Command line arguments (not used).
    */
   
   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
   
      String userLabel;
      double userHeight;
      double userRadius; 
      
      System.out.println("Enter label, height, and radius for a cone."); 
      
      // Get User Inputs 
      System.out.print("\tlabel: ");
      userLabel = input.nextLine();        
      System.out.print("\theight: ");
      userHeight = Double.parseDouble(input.nextLine());
      System.out.print("\tradius: ");
      userRadius = Double.parseDouble(input.nextLine());
      
      // Check Height and Radius is greater than zero.
      if (userHeight <= 0) {
         System.out.print("Error: height must be greater than 0.");
         return;
      }
   
      if (userRadius <= 0) {
         System.out.print("Error: radius must be greater than 0.");
         return;
      }
      
      // Create an instance of Cone and print to console.
      Cone c = new Cone(userLabel, userHeight, userRadius);
      System.out.print(c); 
   }
}