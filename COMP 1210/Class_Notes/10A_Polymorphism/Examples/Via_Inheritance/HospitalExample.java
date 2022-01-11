public class HospitalExample {

   public static void main(String[] args) {
   
      Person[] personArray = new Person[3];   
      personArray[0] = new Patient("Jane", "Lane", "US", 1970);   
      personArray[1] = new Doctor("Joan", "Doe", "Lab", "none");
      ((Doctor) personArray[1]).setSpecialty("Surgeon");	
      personArray[2] = new MaternityPatient("Bo", "Smith", 1990, 40);
   	
      // for (int i = 0; i < personArray.length; i++) {
         // System.out.println("\n" + personArray[i].getId());
      // }
      
      for (Person p : personArray) {
         System.out.println("\n" + p.getId());
      }
      
      System.out.println();
         
      for (Person p : personArray) {
         System.out.println("\n" + p);
      }   
   }
}