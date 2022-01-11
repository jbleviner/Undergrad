import java.util.Scanner;
/**
 * Demonstrates the use of the Scanner class to 
 * read numeric data.
 */
public class DinnerGroup2
{
   /**
    * Calculates restaurant bill based on values 
    * entered by the user.
    *   @param args - Standard commandline arguments
    */
   public static void main(String[] args)
   {
      String name;
      int numOfPersons; 
      double costPerPerson, total;
   
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter the name of group: ");
      name = scan.nextLine();
   
      System.out.print("Enter the number in group: ");
      numOfPersons = scan.nextInt();
   
      System.out.print("Enter cost per person: ");
      costPerPerson = scan.nextDouble();
   
      total = numOfPersons * costPerPerson;
   
      System.out.println("Total Cost: $" + total);
   }
}
