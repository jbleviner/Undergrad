/**
 * Represents an online book item.
 *
 * Activity 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */

public class OnlineBook extends OnlineTextItem {
   
   protected String author;
   
   /**
    * Constructs an onlne book object.
    *
    * @param nameIn name of book
    * @param priceIn price of book 
    */
    
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   /**
    * Sets name of author.
    *
    * @param authorIn auhtor of book
    */
    
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
   
   /**
    * Creates stirng representation of online books.
    *
    * @param 
    * @return output returns string  
    */
   
   public String toString() {
      String output = name + " - " + author + ": $" + price;
      return output;
   }
}