import java.applet.Applet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test extends Applet {
   public static void main(String args[]) {
      go();
      System.out.println("\nApplication");
      System.out.println("CLASSPATH ("
            + System.getProperty("java.class.path") + ")\n");
   
      for (int i = 0; i < args.length; i++)
         System.out.println("   arg " + i + ": " + args[i]);
      go();
      System.out.println("Exit value will be 57.");
      System.exit(57);
   }

   public void init() {
      System.out.println("Applet");
      go();
   }

   private static void go() {  
      BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
      for (int i = 0; i < 5; i++) {
         System.out.print("Enter line: ");
         try {
            String line = reader.readLine();
            System.out.println("line " + i + ": " + line + "\n"); }
         catch (IOException e) {
         }
      }
      System.out.println("done");
   }
}

