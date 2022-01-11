
   import java.io.BufferedReader;
   import java.io.FileInputStream;
   import java.io.InputStreamReader;

   import java.util.StringTokenizer;


/** TwoDArray.java -- This example is intended to illustrate the
 *  capabilities of the two-dimensional array viewer in jGRASP.    
 *  Set a breakpoint inside the loop and launch the debugger.
 *  After program stops at the breakpoint, open a viewer on 
 *  the variable table by "dragging" table out of the Debug tab 
 *  and releasing it. Set View to "2D Array Elements" from the 
 *  drop down list. Now step through the program and observe 
 *  the array viewer. With AutoStep turned on, the debugger 
 *  will begin stepping at the indicated interval when you 
 *  click the Step button. Turning off AutoStep returns the 
 *  debugger to single step mode. **/

    public class TwoDArrayString 
   {
   //-----------------------------------------------------------------
   //  Creates a 2D array of integers, fills it with increasing
   //  integer values, then prints them out.
   //-----------------------------------------------------------------
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
