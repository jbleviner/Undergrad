import javax.swing.JOptionPane;

/**
 * Program that prints the results of integer and decimal division.
 *
 * Activity 11
 * @author Kevin Bumgarner - COMP - 1210 - 003 
 * @version Novemebr 25th, 2018
 */
 
public class DivisionDriver {

/**
 * Main method, asks user for a numerator and denominator
 *    then prints the the results of the two numbers manipulated  
 *    by integer and decimal division. 
 *
 * @param args command line arguments - not used 
 */
 
 
   public static void main(String[] args) {
   
   
      String numInput = JOptionPane.showInputDialog("Enter the numerator:");
      String denomInput = JOptionPane.showInputDialog("Enter the denominator:");
   
      try {
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
      
      
         String result = "Integer division: \n"
            + Division.intDivide(num, denom)
            + "\n\nFloating point division: \n"
            + Division.decimalDivide(num, denom);
      
         JOptionPane.showMessageDialog(null, result,
            "Result", JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException e) {
       
         JOptionPane.showMessageDialog(null,
            "Invalid input: Enter numerical integer values only.",
            "error", JOptionPane.ERROR_MESSAGE);    
      }
      catch (IllegalArgumentException e) {
         
         JOptionPane.showMessageDialog(null, e, "Error", 
            JOptionPane.PLAIN_MESSAGE);
      }
   }
}