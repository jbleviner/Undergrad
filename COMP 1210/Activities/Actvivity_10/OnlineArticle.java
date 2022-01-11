/**
 * Represents an online article item.
 *
 * Activity 09/10
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 5th, 2018
 */

public class OnlineArticle extends OnlineTextItem { 
   
   private int wordCount;

   /**
    * Constucts OnlineArticle object.
    *
    * @param nameIn name of article  
    * @param priceIn price of article  
    */
    
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0; 
   }
   
   /**
    * Sets word count.
    *
    * @param wordCountIn word count of article
    */
   
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}