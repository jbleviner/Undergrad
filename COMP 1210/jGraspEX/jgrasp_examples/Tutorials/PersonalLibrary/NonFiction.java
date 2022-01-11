
/** Class representing a work of nonfiction. */
public class NonFiction extends Book {

   /**
    * The topic of the book, or "TBD" if a topic has not
    *  been set.
    */
   protected String topic = new String("TBD");


   /** Creates a NonFiction with default values. */
   public NonFiction() {
      super();
   }


   /**
    * Creates a NonFiction with an undefined topic.
    *
    * @param theAuthor the author.
    *
    * @param theTitle the title.
    *
    * @param thePages the number of pages.
    *
    * @param thePrice the price in arbitrary units.
    */
   public NonFiction(String theAuthor, String theTitle,
         int thePages, Double thePrice) {
      super(theAuthor, theTitle, thePages, thePrice);
   }

   /**
    * Creates a NonFiction.
    *
    * @param theAuthor the author.
    *
    * @param theTitle the title.
    *
    * @param thePages the number of pages.
    *
    * @param thePrice the price in arbitrary units.
    *
    * @param theTopic the book's topic.
    */
   public NonFiction(String theAuthor, String theTitle,
         int thePages, Double thePrice, String theTopic) {
      super(theAuthor, theTitle, thePages, thePrice);
   
      topic = theTopic;
   }


   /**
    * Gets the topic.
    *
    * @return the book's topic.
    */
   public String getTopic() {
      return topic;
   }


   /** {@inheritDoc} */
   public String toString() {
      return super.toString() + "\nTopic: " + topic;
   }
}
