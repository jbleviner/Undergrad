import java.util.Scanner;

  /**
    * This program will read in a message from the user and then require the 
    *    user to enter a number. The following will happen based on the number 
    *    entered by user:
    * If the user enters a 1, the message will be printed trimmed.
    * If the user enters a 2, the message will be printed in lower case.
    * If the user enters a 3, the message will be printed in upper case.
    * If the user enters a 4, the message will be printed with all vowels 
    *    replaced with underscores.
    * If the user enters a 5, the message will be printed without the first 
    *    and last character. 
    * Any other number should generate an appropriate message.
    *
    * Activity 3
    * @author Kevin Bumgarner - COMP 1210 - 003
    * @version September 9th, 2018
    */

public class MessageConverter {

/**
 * Asks user for a message and modifies and prints the users 
 *    message according to a second input or "choice".
 * @param args Command line arguments - not used 
 */ 
   
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String message = "";
      int outputType;
      String result = "";
      
      // ask user for a message 
      System.out.print("Type in a message and press enter:\n\t> ");
      message = userInput.nextLine();
      
      // displays options to edit users message and asks for second input   
      System.out.print("\nOutput types:" 
         + "\n\t0: As is"
         + "\n\t1: Trimmed"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\n\t5: Without first and last character" 
         + "\nEnter your choice: ");
      
      outputType = Integer.parseInt(userInput.nextLine());
      
      // stores "result" variable based on user input 
      if (outputType == 0) { // as is
         result = message;
      }
      else if (outputType == 1) { // trimmed
         result = message.trim();
      }
      else if (outputType == 2) { // lower case 
         result = message.toLowerCase();
      }
      else if (outputType == 3) { // upper case 
         result = message.toUpperCase();
      }
      else if (outputType == 4) { // replace vowels 
         result = message.replace('a', '_');
         result = result.replace('e', '_');
         result = result.replace('i', '_');
         result = result.replace('o', '_');
         result = result.replace('u', '_');
      }
      else if (outputType == 5) { // without first and last character
         result = message.substring(1, message.length() - 1);
      }
      else { // invalid input
         result = "Error: Invalid choice input.";
      }
      // prints new message 
      System.out.print("\n" + result);
      
   }
}