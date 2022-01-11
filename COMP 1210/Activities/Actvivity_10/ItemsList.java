/**
 * Program holds a List of InventoryItem objects.  
 *
 * Activity 10 
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 12th, 2018 
 */

public class ItemsList {

   private InventoryItem[] inventory;
   private int count;

/**
 * Initializes Items Lists.
 *
 * @param
 */
 
   public ItemsList() {
   
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   /**
    * Adds item to list.
    *
    * @param itemIn an inventory item
    */
    
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
    
    /**
     * Calculates total.
     *
     * @param electronicsSurcharge total surcharge 
     * @return total returns total  
     */
     
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
      
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         } 
      
      }
      return total;
   }
   
   /**
    * Creates a String representation of items list.
    *
    * @param 
    * @return output returns String
    */
    
   public String toString() {
      String output = "All inventory:\n\n";
    
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      } 
    
      return output;
   }
     
}