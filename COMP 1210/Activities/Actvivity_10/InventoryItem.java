/**
 * Super class that represents an inventory item in a store. 
 *
 * Activity 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */


public class InventoryItem {

// ****************************************************
// Instance Variables 
// ****************************************************

   protected String name = "";
   protected double price = 0;
   private static double taxRate = 0;
   
// ****************************************************
// Constructor
// ****************************************************

    /**
     * Constructor for IventoryItem.
     *
     * @param nameIn name 
     * @param priceIn price 
     */
     
   public InventoryItem(String nameIn, double priceIn) {
   
      name = nameIn;
      price = priceIn;
   }
   
   /**
    * Gets name of the item.
    *
    * @param 
    * @return name name of item
    */
   
   public String getName() {
      return name;
   }
   
   /**
    * Calculates total cost.
    *
    * @param 
    * @return cost cost of item
    */
   
   public double calculateCost() {
      double cost = price * (1 + taxRate);
      return cost;
   }
   
   /**
    * Sets tax rate for item.
    *
    * @param taxRateIn tax rate 
    */
   
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   } 
   
   /**
    * Represents InventoryItem as a String.
    *
    * @param 
    * @return output returns string 
    */
   
   public String toString() {
      String output = name + ": $" + calculateCost();
      return output;
   } 
}
