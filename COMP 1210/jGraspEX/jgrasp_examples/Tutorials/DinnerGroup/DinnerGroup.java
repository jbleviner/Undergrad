public class DinnerGroup
{
   public static void main(String[] args)
   {
      String name;
      int numOfPersons; 
      double costPerPerson;
      double total;
      
      name = "Smith and Jones";
      numOfPersons = 10;
      costPerPerson = 12.99;
      total = numOfPersons * costPerPerson;
   
      System.out.println("Total Cost: $" + total);
   }
}
