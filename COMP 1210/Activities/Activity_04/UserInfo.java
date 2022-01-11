/**
 * Program that creates methods to be called on in 
 * the driver class UserInfoDriver.java:
 * setLocation, setAge, getAge, getLocation, logOff,logOn.
 * Creates object UserInfo.
 *
 * Activity 4A
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version September 17th, 2018
 */
 
public class UserInfo {
// instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;

// constructor

/**
 * Initializes variables for UserInfo.
 *
 * @param firstNameIn The first name of user
 * @param lastNameIn The last name of user
 */
 
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }

// methods

/**
 * Creates a String output.
 *
 * @param
 * @return output returns output 
 */

   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      } 
      return output;
   }
   
   /**
    * Method to set location of user.
    *
    * @param locationIn location of user
    */
    
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
    * Method to set age of user.
    *
    * @param ageIn age of user
    * @return isSet returns age of user
    */
    
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   
   /**
    * Gets age of user. 
    * 
    * @param 
    * @return age returns age
    */
   
   public int getAge() {
      return age;
   }
   
   /**
    * Gets location.
    * 
    * @param
    * @return location returns location
    */
    
   public String getLocation() {
      return location;
   }
   
   /**
    * Sets status to Offline.
    *
    * @param
    */
   
   public void logOff() {
      status = OFFLINE;
   }
   
    /**
    * Sets status to Online.
    *
    * @param
    */  
   
   public void logOn() {
      status = ONLINE;
   }
}