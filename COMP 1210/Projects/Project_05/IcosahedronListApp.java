import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Program to print out a list of Icosahedron objects.
 *
 * Project 5
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 5th, 2018
 */

public class IcosahedronListApp {

/**
 * Method to print out a list of Icosahedron objects 
 * and summarize them.
 * 
 * @param args command line arguments - not used.
 * @throws FileNotFoundException file is not found  
 */

   public static void main(String[] args) throws FileNotFoundException {
      
      ArrayList<Icosahedron> icoList = new ArrayList<Icosahedron>();
      String listName = "";
      String label = "";
      String color = "";
      double edge = 0;
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println("");
   
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
      
         Icosahedron icoObj = new Icosahedron(label, color, edge);
         icoList.add(icoObj);
      }
      
      scanFile.close();
   
      IcosahedronList myList = new IcosahedronList(listName, icoList);
      
      // Print list of Icosahedrons and summary
   
      System.out.println(myList);
      System.out.println("\n" + myList.summaryInfo());
   }
}