import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/** 
 *  Demonstrates using the PrintWriter class to write a File object
 *  that contains text, without try-catch blocks for FileNotFoundException.
 *  when  
 */
public class WriteLines1 {

   /**
    *  The main method header includes throws FileNotFoundException to avoid 
    *  try-catch blocks for the PrintWriter constructor which is called 
    *  with a File object that may have an invalid file name.
    *  @param args - not used
    *  @throws FileNotFoundException for PrintWriter on file constructor
    */
   public static void main(String[] args) throws FileNotFoundException {
   
      String fileName = "output.txt";
      String output = ""; 
      Scanner keyboardInput = new Scanner(System.in);  
      PrintWriter fileOutput = null;
   
      fileOutput = new PrintWriter(fileName);
      System.out.println("Enter lines you want to write "
            + "to the file or enter DONE.");
      
      output = keyboardInput.nextLine(); // read first line
      while (!(output.trim()).equals("DONE")) {
         fileOutput.println(output);
         output = keyboardInput.nextLine();
      } 
   
      fileOutput.close(); // this line is very important to flush buffer
   }
}