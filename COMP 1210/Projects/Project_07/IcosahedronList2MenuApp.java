import java.util.Scanner;
import java.io.FileNotFoundException;
   
/**
 * Program that allows the user to alter a list of Icosahedrons.
 *
 * Project 6/7
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 18th, 2018
 */
   
public class IcosahedronList2MenuApp {

/**
 * Main method that contains a menu for a user to alter 
 * a list of Icosahedrons. 
 *
 * @param args command line arguments not used
 * @throws FileNotFoundException if file not found
 */

   public static void main(String[] args) throws FileNotFoundException {
   
      String menu = "*** no list name assigned ***";
      
      Icosahedron[] icoArray = new Icosahedron[20];
      IcosahedronList2 myList = new IcosahedronList2(menu, icoArray, 0);
      Scanner userInput = new Scanner(System.in);
      
      char userChoice = 'Q';
      
      String userLabel = "";
      String userColor = "";
      double userEdge = 0;
      
   
   // Print out menu for user
   
      System.out.print("Icosahedron List System Menu"
            + "\nR - Read File and Create Icosahedron List" 
            + "\nP - Print Icosahedron List"
            + "\nS - Print Summary"
            + "\nA - Add Icosahedron"
            + "\nD - Delete Icosahedron"
            + "\nF - Find Icosahedron"
            + "\nE - Edit Icosahedron"
            + "\nQ - Quit");
            
   
      do {
      
         System.out.print("\nEnter Code [R, P, S, A, D, F, E, or Q]: ");
         userChoice = userInput.nextLine().trim().toUpperCase().charAt(0);
         
         // Read file from user input
      
         switch (userChoice) {
            case 'R':
            
               String fileName = "no file name";
               System.out.print("\tFile name: ");
               fileName = userInput.nextLine();
               myList = myList.readFile(fileName);
               System.out.println("\tFile read in and "
                  + "Icosahedron List created");
            
               break;
               
               // Allow user to print contents of file
               
            case'P':
               System.out.print(myList);  
               break;
               
               // Allow user to print summary of file 
         
            case 'S':
               System.out.print("\n" + myList.summaryInfo());
               break;
               
               // Allow user to add to file
         
            case 'A':
               
               System.out.print("\tLabel: ");
               userLabel = userInput.nextLine();
               System.out.print("\tColor: ");
               userColor = userInput.nextLine();
               System.out.print("\tEdge: ");
               userEdge = Double.parseDouble(userInput.nextLine());
               
               myList.addIcosahedron(userLabel, userColor, userEdge); 
               System.out.print("\t*** Icosahedron added ***\n");
            
               break;
               
               // Allow user to delete from file
                
         
            case 'D':
               String label = "";
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               Icosahedron realName = myList.findIcosahedron(label);
               
               // Delete Icosahedron if found 
               
               if (myList.deleteIcosahedron(label) != null) {
                  myList.deleteIcosahedron(label);
                  String realRealName = realName.getLabel();
                  System.out.print("\t\"" + realRealName + "\" deleted\n"); 
               }
               else {
                  System.out.print("\t\"" + label + "\" not found\n");
               }
                
               break;
               
               // Allow user to search file 
         
            case 'F':
               String findLabel = "";
               System.out.print("\tLabel: ");
               findLabel = userInput.nextLine();
            
               if (myList.findIcosahedron(findLabel) != null) {
                  System.out.print(myList.findIcosahedron(findLabel) + "\n");
               }
               else {
                  System.out.print("\t\"" + findLabel + "\" not found" + "\n");
               }
               
               break;
               
               // Allow user to edit contents of file 
         
            case 'E':
               System.out.print("\tLabel: ");
               userLabel = userInput.nextLine();
               System.out.print("\tColor: ");
               userColor = userInput.nextLine();
               System.out.print("\tEdge: ");
               userEdge = Double.parseDouble(userInput.nextLine());
               
               if (myList.findIcosahedron(userLabel) != null) {
                  myList.editIcosahedron(userLabel, userColor, userEdge);
                  System.out.print("\t\"" + userLabel 
                     + "\" successfully edited\n"); 
               }
               else {
                  System.out.print("\t\"" + userLabel + "\" not found\n");
               }
            
               break;
               
               // Quit
               
         
            case 'Q':
            
               break;
         
            default:
               System.out.println("\t*** invalid code ***");
         }
      
      } while (userChoice != 'Q'); 
         
   }
}