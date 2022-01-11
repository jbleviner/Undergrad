import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.awt.Desktop;

/**
 *  WriteRandomHTML.java      
 *
 *  Demonstrates writing random numbers to an HTML file with 
 *  odd numbers in red and even numbers in blue and then opening 
 *  the file in the default web browser.
 */   
public class WriteRandomHTML
{
   static final int MAX = 10;
   /** 
    *  Creates a file of random numbers that consists of ten lines each
    *  containing ten integer values in the range 0 to 99.
    *  @param args - not used
    */ 
   public static void main(String[] args) // throws FileNotFoundException
   {
      
      int value;
      String fileName = "output_random_ints.html";
      PrintWriter outFile = null;
      File theFile = new File(fileName); 
      
      try {
         outFile = new PrintWriter(theFile);      
         outFile.println("<h1>Table of 100 Random Numbers</h1>");
         outFile.println("<p><pre>");
         for (int line = 1; line <= MAX; line++)
         {
            for (int num = 1; num <= MAX; num++)
            {
               value = (int) (Math.random() * 100);
               if (value % 2 == 1) {
                  outFile.print("<b><font color='blue'>" + value 
                              + "</font></b>" + "\t");
               }
               else {
                  outFile.print("<b><font color='red'>" + value 
                              + "</font></b>" + "\t");
               }
            }
            
            outFile.println("<br>");
         }
         
         outFile.println("</pre></p>");   
         outFile.close(); // very important to flush buffer
         System.out.println("Output file has been created: " + theFile);
      } 
      catch (FileNotFoundException excObj) {
         System.out.println("Error: could not create "
                  + "file output.html.");
         return;
      }
         
      try  // open HTML output file in desktop browser
      {
         File f = new File(fileName);
         Desktop dt = Desktop.getDesktop();
         dt.open(f);
      }
      catch (Exception exc) { // handle any exception
         exc.printStackTrace();    
      }
         
   }
}
