public class ContinueForExample {

   public static void main(String[] args) {
   
      String searchStr = "how much wood could a woodchuck chuck " 
            + "if a woodchuck could chuck wood";
      int max = searchStr.length();
      int numUs = 0;
   
      for (int i = 0; i < max; i++) {
         // interested only in u's
         if (searchStr.charAt(i) != 'u') {
            continue;
         }
      
         // process u's
         numUs++;
      }
      System.out.println("Found " + numUs + " u's in the string.");
   }
}