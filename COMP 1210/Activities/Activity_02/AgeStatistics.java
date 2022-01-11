import java.util.Scanner;

/**
 * Program that displays the users name, age, and gender, 
   along with calculations for age in minutes and centuries as 
   well as max heart rate based on age and gender.
 
 * Activity 2
 * @author Kevin Bumgarner COMP - 1210 - 003
 * @version August 31st, 2018
 */
  
public class AgeStatistics {

 /**
  * Uses the System class, and if/else statements 
    to print and calculate name, age, gender, and max heart rate. 
  
  * @param args command line statements - not used 
  */

   public static void main(String[] args) { 
   
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
   
      // Prompt the user for their name: 
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      // Prompt the user for their age:
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
   
      //Prompt user for their gender:
      System.out.print("Enter your gender (1 for female and 0 for male): ");
      gender = userInput.nextInt();
      
      //Calculate the users age in minutes.
      System.out.println("\tYour age in minutes is "
         + ageInYears * 525600 + " minutes.");
      
      //Calculate the users age in centuries.
      System.out.println("\tYour age in centuries is "
         + (double) ageInYears / 100 + " centuries.");
         
      //Display Max Heart Rate.
      System.out.print("Your max heart rate is ");
      
      if (gender == 1) {
         maxHeartRate = 209 - (0.7 * ageInYears);
      }
      
      else {
         maxHeartRate = 214 - (0.8 * ageInYears);
      }
      
      System.out.println(maxHeartRate + " beats per minute.");
     
   }

}