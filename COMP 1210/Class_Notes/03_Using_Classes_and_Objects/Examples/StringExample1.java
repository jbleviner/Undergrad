/**
 * Illustrates declaration and intialization of 
 * String variables and invoking of String methods.
 */
public class StringExample1
{
   /**
    * Declares and intializes String variables then
    * invokes several common methods.  Set breakpoint 
    * open viewers on variables to examine.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args)
   {	
      String title = "Using Classes";
      System.out.println(title);
   
      int count = title.length();
   
      String titleChg1 = title.toUpperCase();
      String titleChg2 = title.toLowerCase();
      String titleChg3 = title.replace('s', 'S');
      String titleChg4 = title.toLowerCase().replace('s', 'S');
      
      System.out.println("title: \"" + title + "\"");
      System.out.println("Length of string: " + count);
      System.out.println(
         
         // Print each change
         System.out.println("titleChg1: " + titleChg1);
      System.out.println("titleChg2: " + titleChg2);
      System.out.println("titleChg3: " + titleChg3);
      System.out.println("titleChg4: " + titleChg4);
   }
}
