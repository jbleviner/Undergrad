import java.util.Scanner;

/**
* Demonstrates the use of the Scanner class to 
* read data from keyboard.
*/
public class AcmeDinnerTheater
{
/**
 * Calculates dinner theater bill based on values 
 * entered by the user.
 * 
 * @param args - Standard commandline arguments
 */
   public static void main(String[] args)
   {
      String name;
      int numOfPersons; 
      double costPerPerson, totalCost;
   
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter group name: ");
      name = scan.nextLine();
   
      System.out.print("Enter the number in group: ");
      numOfPersons = Integer.parseInt(scan.nextLine());
   
      System.out.print("Enter cost per person: ");
      costPerPerson = Double.parseDouble(scan.nextLine());
   
      totalCost = numOfPersons * costPerPerson;
   
      System.out.println("Total Cost: $" + totalCost);
   }
}
