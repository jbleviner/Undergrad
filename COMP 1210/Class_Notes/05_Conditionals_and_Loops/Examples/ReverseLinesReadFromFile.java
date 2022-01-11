import java.util.Scanner;
import java.util.ArrayList;
import java.io.File; // required for input file
import java.io.FileNotFoundException; // required for "throws" in main header

/**
 * Example of reading lines from a file.
 * Reads the lines of text from file.
 * Prints lines in reverse order.
 */
public class ReverseLinesReadFromFile
{
   /**
    * Reads file name from user.
    * Reads line of text from file; store lines in 
    * an ArrayList; prints ArrayList; 
    * print lines in order and then in reverse order;
    
    * @param args Standard command line arguments.
    * @throws FileNotFoundException required by Scanner for File
    */
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);
      String input;
      ArrayList<String> inputList;
      System.out.print("\nEnter file name: ");
      input = scan.nextLine();
      
      // Open Scanner on input file
      Scanner fileScan = new Scanner(new File(input)); 
      inputList = new ArrayList<String>();
      
      // Read each line from file and store in ArrayList
      while (fileScan.hasNext()) {
         inputList.add(fileScan.nextLine());
      }
      fileScan.close();  // close input file
         
      // Print the ArrayList   
      System.out.println(inputList + "\n");
         
      // Print lines in order
      int index = 0;
      while (index < inputList.size()) {
         System.out.println(inputList.get(index) + " ");
         index++;
      }
         
      // Print lines in reverse order
      System.out.print("\n");
      index = inputList.size() - 1;
      while (index >= 0) {
         System.out.println(inputList.get(index) + " ");
         index--;
      }
      
   }
}
