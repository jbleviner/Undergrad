
/** Class representing a book. */
public class Book {

   /**
    * The author's name, or "none" if the author has not
    * been set.
    */
   private String author = new String("none");

   /**
    * The book's title, or "no title" if a title has not
    * been set.
    */
   private String title = new String("no title");

   /** The number of pages in the book. */
   protected int pages = 0;

   /** The book's value in arbitrary units. */
   protected double price = 0.0;


   /** Creates a Book with default values. */
   public Book() {
   }

   /**
    * Creates a Book.
    *
    * @param theAuthor the author.
    *
    * @param theTitle the title.
    *
    * @param thePages the number of pages.
    *
    * @param thePrice the price in arbitrary units.
    */
   public Book(String theAuthor, String theTitle, int thePages,
         Double thePrice) {
      author = theAuthor;
      title = theTitle;
      pages = thePages;
      price = thePrice;
   }

   /**
    * Gets the author.
    *
    * @return author.
    */
   public String getAuthor() {
      return author;
   }
   
   /**
    * Sets the author.
    *
    * @param theAuthor the author's name.
    */
   public void setAuthor(String theAuthor) {
      author = theAuthor;
   }

   /**
    * Gets the title.
    *
    * @return title.
    */
   public String getTitle() {
      return title;
   }
   
   /**
    * Sets the title.
    *
    * @param theTitle the tile of the book.
    */
   public void setTitle(String theTitle) {
      title = theTitle;
   }

   /**
    * Gets the pages.
    *
    * @return pages.
    */
   public int getPages() {
      return pages;
   }
   
   /**
    * Sets the pages.
    *
    * @param thePages the number of pages.
    */
   public void setPages(int thePages) {
      pages = thePages;
   }
   
   /**
    * Gets the price.
    *
    * @return price.
    */
   public double getPrice() {
      return price;
   }
   
   /**
    * Sets the price.
    *
    * @param thePrice the price of the book.
    */
   public void setPrice(double thePrice) {
      price = thePrice;
   }   

 /** {@inheritDoc} */
   public String toString() {
      return ("Author: " + author +  "\nTitle: " + title
            + "\nPages: " + pages + "\nPrice: " + price);
   }
}