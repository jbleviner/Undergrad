import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/** 
 *  Demonstrates try-catch blocks for FileNotFoundException 
 *  when using the PrintWriter class to write a File object
 *  that contains text.   
 */
public class WriteLines2 {

   /**
    *  Handles a FileNotFoundException when the PrintWriter constructor
    *  is called with a File object which has an invalid file name.
    *  @param args - not used
    */
   public static void main(String[] args) {
   
      String fileName = "output.txt";
      String output = ""; 
      Scanner keyboardInput = new Scanner(System.in);  
      PrintWriter fileOutput = null;
   
      try {
         fileOutput = new PrintWriter(fileName);
         System.out.println("Enter lines you want to write "
            + "to the file or enter DONE.");
      
         output = keyboardInput.nextLine(); // read first line
         while (!(output.trim()).equals("DONE")) {
            fileOutput.println(output);
            output = keyboardInput.nextLine();
         } 
      } 
      catch (FileNotFoundException excObj) {
         System.out.println(excObj + "\nCould not open or write "
               + "to file " + fileName);
         return;
      }
      finally {
         if (fileOutput != null) {
            fileOutput.close(); // this line is very important to flush buffer
         }
      }
   }
}