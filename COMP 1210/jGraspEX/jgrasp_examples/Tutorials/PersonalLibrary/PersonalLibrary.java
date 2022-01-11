
/**
 * Class that demonstrates inheritance through a hierarchy
 *
 *  of book types.
 */
public class PersonalLibrary {


   /**
    * Creates several types of books.
    *
    * @param args command line arguments, which are ignored.
    */
   public static void main(String[] args) {
      Book hemingway = new Book("Hemingway",
            "Green Hills of Africa", 234, 50.0);
      Fiction clancy = new Fiction("Clancy",
            "The Hunt for Red October",
            490, 39.0, "Sean");
      Novel grisham = new Novel("Grisham",
            "The Firm", 550, 28.0, "Tom", 0);
   
      System.out.println(hemingway + "\n");
      System.out.println(clancy + "\n");
      System.out.println(clancy.getMainCharacter());
   }
}
