/** 
 * Prints "War Eagle" three times.
 */
public class FirstProgramWithComments2 
{
   /**
    * Prints the line "War Eagle!" three times 
    * to standard output, adding one more '!' with
    * each line printed. 
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args)
   {
      System.out.println("War Eagle!"); 
      
   	// This type of comment begins with // and goes to the end of the line.
      // Here's another one.
      
      /* This type of comment begins with / followed by * 
         and ends with an * followed by a / as shown here.
         It can span one or more lines.
      */
               
      /**
         A Javadoc comment begins with / followed by ** 
         and ends with an * followed by a / as shown here.
         Javadoc comments that directly precede a class or 
         method used by the javadoc utility to generate HTML 
         documentation files for Java files.  
       */
   
      System.out.println("War Eagle!!"); 
      System.out.println("War Eagle!!!"); 
   }
}