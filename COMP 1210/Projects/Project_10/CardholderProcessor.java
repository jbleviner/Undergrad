import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Program that processes Cardholder accounts.
 *
 * Project 10 
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version November 16th, 2018
 */

public class CardholderProcessor {


// ******************************************
// Fields 
// ******************************************

   private Cardholder[] cardArray;
   private String[] invalidRecords;
   

// ******************************************
// Constructor 
// ******************************************


/**
 * Initializes Cardholder Processor objects.
 *
 * @param 
 */
 
   public CardholderProcessor() {
      
      // Initialize fields
      cardArray = new Cardholder[0];
      invalidRecords = new String[0];
   }
   
   
   /**
    * Returns an array of type Cardholder.
    *
    * @param 
    * @return cardArray returns array
    */
    
   public Cardholder[] getCardholdersArray() {
      return cardArray;
   }
   
   /**
    * Gets an array of type String.
    *
    * @param
    * @return invalidRecords returns String array
    */
    
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
    
    /**
     * Adds cardholder Object to cardArray.
     *
     * @param objectIn a Cardholder object 
     */
     
   public void addCardholder(Cardholder objectIn) {
      
      cardArray = Arrays.copyOf(cardArray, cardArray.length + 1);
      cardArray[cardArray.length - 1] = objectIn;
      
   }
   
   /**
    * Adds invalid records to invalidRecordsArray.
    *
    * @param recordIn an invalid file
    */
    
   public void addInvalidRecord(String recordIn) {
    
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = recordIn;
        
   }
   
   /**
    * Reads Cardholder file.
    *
    * @param fileIn file to be read
    * @throws FileNotFoundException if file not found  
    */
    
   public void readCardholderFile(String fileIn) 
      throws FileNotFoundException {
      
      // Create Scanner object to read file.
      Scanner scanFile = new Scanner(new File(fileIn));
      
      while (scanFile.hasNext()) {
      
      // Create Scanner object to read each line.
         String line = scanFile.nextLine();
         Scanner scanLine = new Scanner(line);
         scanLine.useDelimiter(";");
         int category = Integer.parseInt(scanLine.next());
      
        
         switch (category) {
            
            case 1:
            
               while (scanLine.hasNextLine()) {
               
                  String acctNumberIn = scanLine.next();
                  String nameIn = scanLine.next();
                  double prevBalanceIn = Double.parseDouble(scanLine.next());
                  double paymentIn = Double.parseDouble(scanLine.next()); 
                  SapphireCardholder sC = new SapphireCardholder(acctNumberIn, 
                     nameIn);
                  sC.setPrevBalance(prevBalanceIn);
                  sC.setPayment(paymentIn);
               
                  while (scanLine.hasNext()) {
                     sC.addPurchases(Double.parseDouble(scanLine.next()));
                  }
               
                  addCardholder(sC);
               }
               
               break;
            
            case 2:
            
               while (scanLine.hasNextLine()) {
               
                  String acctNumberIn = scanLine.next();
                  String nameIn = scanLine.next();
                  double prevBalanceIn = Double.parseDouble(scanLine.next());
                  double paymentIn = Double.parseDouble(scanLine.next()); 
                  DiamondCardholder dC = new DiamondCardholder(acctNumberIn, 
                     nameIn);
                  dC.setPrevBalance(prevBalanceIn);
                  dC.setPayment(paymentIn);
               
                  while (scanLine.hasNext()) {
                     dC.addPurchases(Double.parseDouble(scanLine.next()));
                  }
               
                  this.addCardholder(dC);
               }
               
               break;
               
            case 3:
               
               while (scanLine.hasNextLine()) {
               
                  String acctNumberIn = scanLine.next();
                  String nameIn = scanLine.next();
                  double prevBalanceIn = Double.parseDouble(scanLine.next());
                  double paymentIn = Double.parseDouble(scanLine.next()); 
                  BlueDiamondCardholder bC = new 
                     BlueDiamondCardholder(acctNumberIn, nameIn);
                  bC.setPrevBalance(prevBalanceIn);
                  bC.setPayment(paymentIn);
               
                  while (scanLine.hasNext()) {
                     bC.addPurchases(Double.parseDouble(scanLine.next()));
                  }
               
                  this.addCardholder(bC);
               }
               
               break;
            
            // Only three cases
            // If code is Invalid ignore line   
            default:
               addInvalidRecord("Invalid Record");
               break;
         }
      }
      
   }
   
   /**
    * Generates report using original order from file.
    *
    * @param 
    * @return "" String 
    */ 
   
   public String generateReport() {
      
      String output = "----------------------------\n";
      output += "Monthly Cardholder Report\n";
      output += "----------------------------\n";
      
      for (int i = 0; i < cardArray.length; i++) {
         output += cardArray[i].toString() + "\n\n";
      }
      
      return output;
   }
   
   /**
    * Generates report based on name.
    *
    * @param 
    * @return output returns String value 
    */
   
   public String generateReportByName() {
   
      String output = "--------------------------------------\n";
      output += "Monthly Cardholder Report (by Name)\n";
      output += "--------------------------------------\n";
      
      // Sort cardArray 
      Arrays.sort(cardArray);
      
      // Create String value based on name
      for (int i = 0; i < cardArray.length; i++) {
         output += cardArray[i].toString() + "\n\n";
      }
      
      return output; 
   }
   
   /**
    * Generates report based on current balance.
    *
    * @param 
    * @return output returns String value
    */
    
   public String generateReportByCurrentBalance() {
   
      String output = "---------------------------------------\n";
      output += "Monthly Cardholder Report (by Current Balance)\n";
      output += "---------------------------------------\n";
      
      // Sort cardArray 
      Arrays.sort(cardArray, new CurrentBalanceComparator());
      
      // Create String value based on name
      for (int i = 0; i < cardArray.length; i++) {
         output += cardArray[i].toString() + "\n\n";
      }
      
      return output; 
   } 

}