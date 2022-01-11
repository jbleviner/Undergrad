import org.junit.Assert;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test file for class Hello.
 * Tests standard output by redirecting System.out
 * to a ByteArrayOutputStream.
 */
public class HelloTest {

   /**
    * Lines of output sent to System.out,
    * one line per element.
    */
   private static ArrayList<String> stdoutLines = new ArrayList<String>();

   /**
    * Fixture initialization (common initialization
    * for all tests).
    */
   @BeforeClass public static void setUp() {
      PrintStream p = System.out;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(baos)); // redirect System.out
      Hello.main(null);
      System.setOut(p);

      String actual = baos.toString();
      Scanner scan = new Scanner(actual);

      while (scan.hasNext()) // move redirected lines to stdoutLines
      {
         stdoutLines.add(scan.nextLine());
      }
   }

    /** Checks line 1 to stdout. */
   @Test public void line1Test() {
      String expected = "Printing to stdout";
      String actual = stdoutLines.get(0);

      Assert.assertEquals("Output line 1: checked and failed. ",
                            expected, actual);
   }

    /** Checks line 2 to stdout. */
   @Test public void line2Test() {
      String expected = "Hello 1";
      String actual = stdoutLines.get(1);

      Assert.assertEquals("Output line 2: checked and failed. ",
                            expected, actual);
   }

   /** Checks line 3 to stdout. */
   @Test public void line3Test() {
      String expected = "Hello 2";
      String actual = stdoutLines.get(2);

      Assert.assertEquals("Output line 3: checked and failed. ",
                            expected, actual);
   }

   /** Checks line 4 to stdout. */
   @Test public void line4Test() {
      String expected = "Hello 3";
      String actual = stdoutLines.get(3);

      Assert.assertEquals("Output line 4: checked and failed. ",
                            expected, actual);
   }

   /** Checks line 5 to stdout. */
   @Test public void line5Test() {
      String expected = "Hello 4";
      String actual = stdoutLines.get(4);

      Assert.assertEquals("Output line 5: checked and failed. ",
                            expected, actual);
   }
}
