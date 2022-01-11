import java.util.Scanner;

/**
* Demonstrates the use of the Scanner class to 
* read numeric data.
*/
public class GroupDinner
{
/**
 * Calculates restaurant bill based on values 
 * entered by the user.
 * 
 * @param args - Standard commandline arguments
 */
   public static void main(String[] args)
   {
      String name;
      int numOfPersons; 
      double costOfMeal, total;
   
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter group name: ");
      name = scan.nextLine();
   
      System.out.print("Enter the number in group: ");
      numOfPersons = Integer.parseInt(scan.nextLine());
   
      System.out.print("Enter cost per person: ");
      costOfMeal = Double.parseDouble(scan.nextLine());
   
      total = numOfPersons * costOfMeal;
   
      System.out.println("Total Cost: $" + total);
   }
}
