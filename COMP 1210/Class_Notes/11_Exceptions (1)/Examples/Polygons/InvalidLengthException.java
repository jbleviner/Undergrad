/**
 *  InvalidLengthException for Pologon.
 */
public class InvalidLengthException extends Exception 
   //extends RuntimeException 
{
   /**
    *  @param invalidSide of Polygon
    */
   public InvalidLengthException(double invalidSide) {
      super("Invalid length for side: " + invalidSide + ". "
            + "A valid length must be greater than 0.");
   }

}