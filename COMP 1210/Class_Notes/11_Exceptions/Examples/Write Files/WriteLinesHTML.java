import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Desktop;

/** 
 *  Demonstrates try-catch blocks for FileNotFoundException 
 *  when using the PrintWriter class to write a File object
 *  that contains text with simple html tags, and then opens 
 *  the file in the default web browser.
 */
public class WriteLinesHTML {

   /**
    *  Handles a FileNotFoundException when the PrintWriter constructor
    *  is called with a File object which has an invalid file name.
    *  @param args - not used
    */
   public static void main(String[] args) {
   
      String fileName = "output.html";
      String output = ""; 
      Scanner keyboardInput = new Scanner(System.in);  
      PrintWriter fileOutput = null;;
   
      try {
         fileOutput = new PrintWriter(fileName);
         System.out.println("Enter lines you want to write "
            + "to the file or enter DONE.");
      
         fileOutput.println("<p>");
      
         output = keyboardInput.nextLine(); // read first line
         while (!(output.trim()).equals("DONE")) {
         
            fileOutput.println("<b><font color='blue'>" + output 
                           + "</font></b>" + "<br>");
            output = keyboardInput.nextLine();
         } 
      
         fileOutput.println("</p>");
      }
      catch (FileNotFoundException excObj) {
         System.out.println("Error: could not create "
               + "file output.html.");
         return; // just end the program
      }
      finally {
         if (fileOutput != null) {
            fileOutput.close(); // very important to flush buffer
         }
      }
   
      try  // open HTML output file in desktop browser
      {
         File f = new File(fileName);
         Desktop dt = Desktop.getDesktop();
         dt.open(f);         
      }
      catch (Exception exc) { // handles any exception
         exc.printStackTrace();    
      }
   }
}