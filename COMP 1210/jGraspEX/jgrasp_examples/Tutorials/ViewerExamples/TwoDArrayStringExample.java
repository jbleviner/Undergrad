
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * TwoDArrayStringExample.java - This example is intended 
 * to illustrate the capabilities of the Presentation 
 * Structure Identifier rendering of a 2D array 
 * in the viewer canvas.  
 * 
 * Click the "Run in Canvas" button on the toolbar. Then on 
 * the canvas window, click the "Play" button. Regulate the 
 * speed with the "Delay" slider. Select the viewer and scroll
 * as needed.
 * 
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you 
 * see objects and primitives of interest in the Variables tab 
 * and then drag them onto the canvas. For this example, drag 
 * the variable table on to the canvas). On the viewer for table, 
 * click the menu button (the down arrowhead on the upper-right
 * corner of the viewer), select "Viewer" then "2D Array Elements".
 * Now click the "Play" button.
 */
public class TwoDArrayStringExample {

   /**
    * Creates a 2D array of integers, fills it with increasing
    * integer values, then prints them out.
    *
    * @param args command line arguments, which are ignored.
    */
   public static void main(String[] args) throws Exception {
      String[][] table = new String[5][10];
   
      FileInputStream fis = new FileInputStream("testwords.dat");
      InputStreamReader isr = new InputStreamReader(fis, "ISO-8859-1");
      BufferedReader reader = new BufferedReader(isr);
   
      int row = 0;
      String line;
      while ((line = reader.readLine()) != null) {   
         int col = 0;
         StringTokenizer words = new StringTokenizer(line);
         
         while (words.hasMoreTokens()) {
            table[row][col] = words.nextToken();
            System.out.println(table[row][col]);
            col++;
         }
         row++;
         System.out.println();
      }
         
      reader.close();
      System.out.println("Input file \"test.dat\" has been read!");
   }
}
