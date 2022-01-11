/**
 * Program that displays items and their prices.
 *
 * Activity 09
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */

public class InventoryApp {

/**
 * Main Method, prints items.
 *
 * @param args command line arguments - not used 
 */

   public static void main(String[] args) {
      
      InventoryItem.setTaxRate(0.05);
      
      InventoryItem item1 = new InventoryItem("Oil change kit", 39.00);
      System.out.println(item1);
      
      ElectronicsItem item2 = new ElectronicsItem("Cordless phone", 80.00, 1.8);
      System.out.println(item2);
      
      OnlineArticle item3 = new OnlineArticle("Java News", 8.50);
      item3.setWordCount(700);
      System.out.println(item3);
      
      OnlineBook item4 = new OnlineBook("Java for Noobs", 13.37);
      item4.setAuthor("L. G. Jones");
      System.out.print(item4);
       
   }
}