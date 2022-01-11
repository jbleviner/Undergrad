import java.util.Scanner;

/**
 *  Program that accepts a raw time measurement in seconds (of type int) 
 *  and then displays the time as a combination of days, hours, minutes, and 
 *  seconds. When a negative raw time measurement is entered, an appropriate 
 *  message is printed as shown in the first of the two examples below. 
 *
 * Project 2 
 * @author Kevin Bumgarner - COMP 1210 - 003
 * @version septemeber 4th, 2018
 */
 
public class TimeConverter {

 /**
  * Prompts user for raw time data in Seconds, then prints an 
  * output based on the user input. 
  * 
  *  @param args Command line arguments - not used 
  */
   
   public static void main(String[] args) {
      
      // Declare variables and initial statement.
      int timeSeconds, days, hours, minutes, seconds;
      Scanner userTime = new Scanner(System.in);
      
      System.out.print("Enter the raw time measurement in seconds: ");
      timeSeconds = userTime.nextInt();
      System.out.println();
      
      // Get equations for combined days, hours, minutes, seconds.
      days = timeSeconds / 86400;
      hours = (timeSeconds % 86400) / 3600;
      minutes = ((timeSeconds % 86400) % 3600) / 60;
      seconds = (((timeSeconds % 86400) % 3600) % 60) / 1;
      
         // Determine output based on user input (timeSeconds).
      if (timeSeconds < 0) {
         System.out.println("Measurement must be non-negative!");
      }
      
      else {
         // Print combined days, hours, minutes, seconds.
         System.out.println("Measurement by combined days, "
            + "hours, minutes, seconds:");
         System.out.println("\tdays: " + days); 
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " + seconds);
         System.out.println();
         System.out.println(timeSeconds + " seconds = " 
            + days + " days, " + hours 
            + " hours, " + minutes + " minutes, " + seconds + " seconds");
      
      }
   }
}