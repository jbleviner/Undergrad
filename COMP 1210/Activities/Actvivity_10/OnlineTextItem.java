/**
 * Represents an online text item.
 *
 * Activity 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */
 
public abstract class OnlineTextItem extends InventoryItem {

   /**
    * Constucts online text item objects.
    *
    * @param nameIn name of item 
    * @param priceIn price of item 
    */
 
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Calculates cost.
    *
    * @param
    * @return price price of item
    */
    
   public double calculateCost() {
      return price;
   }
}