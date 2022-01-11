/** Converts temperatures between Celsius and Farenheit. */    
public class TemperatureConverter {

   /** Count for conversions to Celsius. */
   private int conversionsToCelsius;

   /** Count for conversions to Farenheit. */
   private int conversionsToFahrenheit;
   
   /** Creates a TemperatureConverter. */   
   public TemperatureConverter() {
      conversionsToCelsius = 0;
      conversionsToFahrenheit = 0;
   }
   
   /**
    * Gets the number of conversions to Celsius.
    *
    * @return the number of conversions to Celsius.
    */    
   public double getConversionsToCelsius() {
      return conversionsToCelsius;
   }
   
   /**
    * Sets the number of conversions to Celsius.
    *
    * @param count the new number of conversions to Celsius. */   
   public void setConversionsToCelsius(int count) {
      conversionsToCelsius = count;
   }

   /**
    * Gets the number of conversions to Fahrenheit.
    *
    * @return the number of conversions to Fahrenheit.
    */    
   public double getConversionsToFahrenheit() {
      return conversionsToFahrenheit;
   }

   /**
    * Sets the number of conversions to Fahrenheit.
    *
    * @param count the new number of conversions to Fahrenheit. */   
   public void setConversionsToFahrenheit(int count) {
      conversionsToFahrenheit = count;
   }
   
   /** Sets the conversion counters to zero. */    
   public void resetCounters() {
      conversionsToCelsius = 0;
      conversionsToFahrenheit = 0;
   }
   
   /**
    * Converts temperature in Farenheit to Celsius.
    *
    * @param f the temperature in Fahrenheit.
    *
    * @return the temperature in Celsius.
    */       
   public double convertToCelsius(double f) {
      double c = (f - 32) * (5.0 / 9);
      conversionsToCelsius++;
      return c;
   }

   /**
    * Converts temperature in Celsius to Farenheit.
    *
    * @param c the temperature in Celsius.
    *
    * @return the temperature in Farenheit.\
    */       
   public double convertToFarenheit(double c) {
      double f = c * (9.0 / 5) + 32;
      conversionsToFahrenheit++;
      return f;
   }
}