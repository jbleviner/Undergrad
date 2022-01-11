
/**
 * Provides a factory method for creating word search games. 
 *
 * @author Kevin Bumgarner (kgb0022@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 03-28-20
 */
public class WordSearchGameFactory {

   /**
    * Returns an instance of a class that implements the WordSearchGame
    * interface.
    */
   public static WordSearchGame createGame() {
      return new MyWordSearch();
   }

}
