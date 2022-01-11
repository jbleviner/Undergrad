/**
 * Program that defines a customer object.
 *
 * Activity 08B
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 27th, 2018 
 */

public class Customer implements Comparable<Customer> {

// Instance Variables

   private String name = "";
   private String location = "";
   private double balance = 0;

// Constructor 

/**
 * Constructor method for customer objects. 
 *
 * @param nameIn name of customer 
 */
   public Customer(String nameIn) {
      
      name  = nameIn; // sets name to parameter input
      location = ""; // sets location to empty string
      balance = 0; // sets balance to 0
   }
   
   /**
    * Method to set location of customer. 
    *
    * @param locationIn location of customer 
    */
   
   public void setLocation(String locationIn) {
      if (locationIn != null) {
         location = locationIn;
      }
   }
   
   /**
    * Method to change balance by inputed amount.
    *
    * @param amount said amount 
    */
   
   public void changeBalance(double amount) {
      balance += amount;
   }
   
   /** 
    * Method to get location.
    *
    * @param 
    * @return location returns location 
    */
   
   public String getLocation() {
      return location;
   }
   
   /**
    * Method to get balance.
    *
    * @param 
    * @return balance returns balance 
    */
    
   public double getBalance() {
      return balance;
   }
   
   /**
    * Method to set location.
    *
    * @param city city
    * @param state state 
    */
   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }
   
   /**
    * Creates a string representation of a customer object.
    *
    * @param 
    * @return output returns string 
    */
  
   public String toString() {
      
      String output = name 
         + "\n"
         + location
         + "\n$"
         + balance;
         
      return output;
   }
   
   /**
    * Compare two customer objects.
    *
    * @param obj a customer object
    * @return 0 returns 0 
    */
   
   public int compareTo(Customer obj) {
   
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      }
      else if (this.balance < obj.getBalance()) {
         return -1;
      }
      else {
         return 1;
      } 
   }
   
}


