import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

/**
 *  WriteReadRandom.java
 *
 *  Demonstrates the use (writing and reading) of a text file.
 */
public class WriteReadRandom
{
   static final int MAX = 10;

   /**
    *  Creates a file that consists of ten lines each
    *  containing ten integer values in the range 0 to 99,
    *  then reads the file and prints each line.
    *  @param args not used
    */
   public static void main(String[] args) //throws FileNotFoundException
   {
   
      int value;
      String fileName = "/random_ints.txt";
   
      try {
         PrintWriter outFile = new PrintWriter(new File(fileName));
      
         for (int line = 1; line <= MAX; line++)
         {
            for (int num = 1; num <= MAX; num++)
            {
               value = (int) (Math.random() * 100);
               outFile.print(value + "\t");
            }
            outFile.println();
         }
         outFile.close();
         System.out.println("Output file has been created: " 
                                 + fileName);
      
         Scanner inFile = new Scanner(new File(fileName));
         while (inFile.hasNext())
         {   
            String line = inFile.nextLine();
            System.out.println(line);
         }
         inFile.close(); 
         System.out.println("Input file \"" + fileName + "\" "
                        + "has been read and printed!");
      }
      catch (FileNotFoundException excObj) {
         System.out.println("Error: could not open "
                  + "file " + fileName);
      }
   }
}
