import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
   
/** 
 *  Demonstrates try-catch blocks for FileNotFoundException 
 *  when using Scanner class to read a File object.
 */
public class ReadLines1
{   
   /**
    *  The main method header includes throws a FileNotFoundException 
    *  when the Scanner constructor is called with a File object which 
    *  has an invalid file name.
    *  @param args - not used
    */
   public static void main(String[] args) throws FileNotFoundException
   {   
      String fileName = "";
      Scanner fileInput = null;
      int lineCount = 0;
      Scanner keyboardInput = new Scanner(System.in);
         
      System.out.print("Enter a file name: ");
      fileName = keyboardInput.nextLine();
         
      fileInput = new Scanner(new File(fileName));
      	
      while (fileInput.hasNextLine()) {
         lineCount++;
         System.out.println("Line " + lineCount + ": " 
                           + fileInput.nextLine());
      }
         
      System.out.println("\nThere were " + lineCount 
            + " line(s) in the file.");
      
      fileInput.close(); // good practice to close input file
   }
}