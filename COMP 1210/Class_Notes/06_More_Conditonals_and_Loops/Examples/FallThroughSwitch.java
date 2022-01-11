import java.util.Scanner;

/**
 * Demonstrates a fall through a switch (missing break 
 * statements) used to print days of week remaining.
 */
public class FallThroughSwitch {

   /**
    * Requests day of week abbreviation from user 
    * then prints days of week remaining beginning 
    * with that day.
    * 
    * @param args - not used
    */
   public static void main(String[] args) {
      java.util.ArrayList<String> futureDaysOfWeek =
         new java.util.ArrayList<String>();
         
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Print days of week remaining,"
         + "\nbeginning with day of week entered"
         + "\n(e.g., Su or Sun for Sunday): ");
      String dayOfWeek = scan.next().toUpperCase();
      
      switch (dayOfWeek) {
         case "SU":
         case "SUN": 
            System.out.println("   Sunday");
            
         case "MO":
         case "MON": 
            System.out.println("   Monday");
            
         case "TU":
         case "TUE": 
            System.out.println("   Tuesday");
            
         case "WE": case "WED": System.out.println("   Wednesday");
            
         case "TH": case "THU": System.out.println("   Thursday");
            
         case "FR": case"FRI":  
            System.out.println("   Friday");
            
         case "SA": case"SAT": 
            System.out.println("   Saturday");
            break;
            
         default: 
            System.out.println("Invalid day of week number");
            break; // Not required here, but many 
      }            // include for consistency.
   }
}