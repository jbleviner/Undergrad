/** 
 * Program that adds and prints out a list of inventory items.
 *
 * Activity 10
 * @author Kevin Bumgarner - COMP - 1210 - 003 
 * @version November 12th, 2018 
 */
 
public class InventoryListApp {

/**
 * Prints out myItems.
 *
 * @param args command line arguments - not used
 */
 
   public static void main(String[] args) {
      
      // Create list 'myItems'
      ItemsList myItems = new ItemsList();
      
      // Set tax rate 
      InventoryItem.setTaxRate(0.05);
      
      // Add items items to myItems
      myItems.addItem(new ElectronicsItem("laptop", 1234.56, 10));
      myItems.addItem(new InventoryItem("motor oil", 9.8));
      myItems.addItem(new OnlineBook("All Things Java", 12.3));
      myItems.addItem(new OnlineArticle("Useful Acronyms", 3.4));
      
      System.out.println(myItems.toString());
      System.out.print("Total: " + myItems.calculateTotal(2.0));
        
   }
}