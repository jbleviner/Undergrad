import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
   
/** 
 *  Demonstrates try-catch blocks for FileNotFoundException 
 *  when using Scanner class to read a File object.
 */
public class ReadLines2 
{   
   /**
    *  Handles a FileNotFoundException when the Scanner constructor
    *  is called with a File object which has an invalid file name.
    *  @param args - not used
    */
   public static void main(String[] args) //throws FileNotFoundException
   {   
      String fileName = "";
      Scanner fileInput = null;
      int lineCount = 0;
      Scanner keyboardInput = new Scanner(System.in);
         
      System.out.print("Enter a file name: ");
      fileName = keyboardInput.nextLine();
         
      try {
         fileInput = new Scanner(new File(fileName));
      	
         while (fileInput.hasNextLine()) {
            lineCount++;
            System.out.println("Line " + lineCount + ": " 
                           + fileInput.nextLine());
         }
         
         System.out.println("\nThere were " + lineCount 
            + " line(s) in the file.");
      }
      
      // Since FileNotFoundException is a subclass of IOException 
      // so you could catch IOException instead of FileNotFoundException
      catch (FileNotFoundException excepObj) {
         System.out.println("Error: File was not found.");
         //System.out.println(excepObj);
      } 
      finally {
         if (fileInput != null) {
            fileInput.close(); // good practice to close input file
         }
      }
   }
}