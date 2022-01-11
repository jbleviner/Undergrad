/**
 * Represents an electronics item.
 *
 * Activity 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */

public class ElectronicsItem extends InventoryItem {

   protected double weight = 0;
   
   /**
    * Constant SHIPPING_COST.
    */
   
   public static final double SHIPPING_COST = 1.5;
   
   /**
    * Constructs an Electronics item.
    *
    * @param nameIn name of item
    * @param priceIn price of item 
    * @param weightIn weight of item  
    */
   
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      
      super(nameIn, priceIn);
      weight = weightIn;
   }
   
   /**
    * Calculates cost.
    *
    * @param 
    * @return cost cost of item 
    */
   
   public double calculateCost() {
      double cost = super.calculateCost() + (SHIPPING_COST * weight);
      return cost;
   }  
}