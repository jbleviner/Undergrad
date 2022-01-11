
/** Class representing a novel. */
public class Novel extends Fiction {

   /** The number of sequels. */
   private int sequels = 0;


   /** Creates a Novel with default values. */
   public Novel() {
      super();
   }

   /**
    * Creates a Fiction.
    *
    * @param theAuthor the author.
    *
    * @param theTitle the title. 
    *
    * @param thePages the number of pages.
    *
    * @param theValue the value in arbitrary units.
    *
    * @param theMainCharacter the main character's name.
    *
    * @param sqls the number of sequels.
    */
   public Novel(String theAuthor, String theTitle, int thePages,
         Double theValue, String theMainCharacter, int sqls) {
      super(theAuthor, theTitle, thePages, theValue, theMainCharacter);
      sequels = sqls;
   }


   /** {@inheritDoc} */
   public String toString() {
      return super.toString() + "\nNumber of sequels: " + sequels;
   }
}
