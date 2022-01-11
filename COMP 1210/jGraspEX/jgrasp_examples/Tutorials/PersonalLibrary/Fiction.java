
/** Class representing a work of fiction. */
public class Fiction extends Book implements Comparable<Fiction> {

   /**
    * The main character's name, or "none" if the main
    * character has not been set.
    */
   protected String mainCharacter = new String("none");


   /** Creates a Fiction with default values. */
   public Fiction() {
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
    */
   public Fiction(String theAuthor, String theTitle,
         int thePages, Double theValue, String theMainCharacter) {
      super(theAuthor, theTitle, thePages, theValue);
      mainCharacter = theMainCharacter;
   }


   /**
    * Sets the main character.
    *
    * @param theMainCharacter the main character's name.
    */
   public void setMainCharacter(String theMainCharacter) {
      mainCharacter = theMainCharacter;
   }

   /**
    * Gets the main character.
    *
    * @return the main character's name.
    */
   public String getMainCharacter() {
      return mainCharacter + "";
   }


   /** {@inheritDoc} */
   public String toString() {
      return super.toString() + "\nMain Character: " + mainCharacter;
   }


   /** {@inheritDoc} */
   public int compareTo(Fiction obj) {
      //Comparable cFiction = this;
      //return (price == (((Fiction) obj).price));
      Double dPrice = price;
      return (new Double(price)).compareTo(new Double(obj.price));
   }
}
