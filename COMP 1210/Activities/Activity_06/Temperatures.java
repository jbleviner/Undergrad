import java.util.ArrayList;

/**
 * Program to hold a set of integer values representing
 * daily temperatures.
 *
 * Activity 06
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version October 8th, 2018 
 */
 
public class Temperatures {

// ===============================================================
// Instance variables 
// ===============================================================

   private ArrayList<Integer> temperatures;
   
   // ============================================================
   // Constructor
   // ============================================================
   
   /**
    * Constructor to initialize a Temperatures object.
    *
    * @param temperaturesIn ArrayList of temperatures
    *
    */
   
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }
   
   // ============================================================
   // Methods 
   // ============================================================
   
   /**
    * Method to get lowest temperature. 
    *
    * @param 
    * @return low returns lowest temp
    */
    
   public int getLowTemp() {
      
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   
   /**
    * Method to get highest temperature.
    *
    * @param 
    * @return high returns highest temp
    */
    
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         } 
      }
      
      return high;
   }
    
    /**
     * Method that takes an int value and returns the parameter if 
     * it is lower than the value returned by getLowTemp. 
     * Otherwise, it returns the return of getLowTemp.
     *
     * @param lowIn a temperature value 
     * @return lowIn or getLowTemp()
     */
     
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   
   /**
    * Method that takes an int value and returns the parameter 
    * if it is greater than than the value returned by getHighTemp. 
    * Otherwise, it returns the return of getHighTemp.
    *
    * @param highIn a temperature value
    * @return highIn or getHighTemp()
    */
    
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   
   /**
    * Creartes a string representation of Temperatures.
    *
    * @param
    * @return "" returns string 
    */
    
   public String toString() {
      return "\tTemperatures: " + temperatures
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   } 
   
    
}