import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
   
/** 
 *  Demonstrates try-catch blocks for FileNotFoundException 
 *  when using Scanner class to read a File object within 
 *  loop to enter file name.
 */
public class ReadLines4 
{   
   /**
    *  Handles a FileNotFoundException when the Scanner constructor
    *  is called with a File object which has an invalid file name and 
    *  requests user to enter file name (or blank to end) 
    *  until file is found.  Uses a single try block.
    *  @param args - not used
    */
   public static void main(String[] args) //throws FileNotFoundException
   {   
      String fileName;
      Scanner fileInput = null; // so that fileInput is intialized
      int lineCount = 0;
      Boolean found = false;
      Scanner keyboardInput = new Scanner(System.in);
      
      do {   
         try {
            System.out.print("Enter a file name (or blank to end): ");
            fileName = keyboardInput.nextLine().trim();
            if (fileName.equals("")) {
               System.out.println("No file name entered - program ending.");
               return;
            }
         
            fileInput = new Scanner(new File(fileName));
            found = true;
            while (fileInput.hasNextLine()) {
               lineCount++;
               System.out.println("Line " + lineCount + ": " 
                  + fileInput.nextLine());
            }
         
            System.out.println("\r\nThere were " + lineCount 
               + " line(s) in the file.");
         }
         catch (FileNotFoundException excepObj) {
            System.out.println("Error: Could not find the file.");
            //System.out.println(excepObj);
         } 
         finally {
            if (fileInput != null) {
               fileInput.close(); // good practice to close input file
            }
         }      
      } while (!found); 
      
   }
}