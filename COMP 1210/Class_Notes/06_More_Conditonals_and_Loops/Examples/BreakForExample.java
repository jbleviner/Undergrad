public class BreakForExample {

   public static void main(String[] args) {
   
      String searchMe = "how much wood could a woodchuck chuck " 
            + "if a woodchuck could chuck wood";
      char searchForLast = 'h';
      int start = searchMe.length() - 1;
   
      boolean foundIt = false;
      int index;
      for (index = start; index >= 0; index--) {
      
         if (searchMe.charAt(index) == searchForLast) {
            foundIt = true;
            break;
         }
      }
      
      if (foundIt) {
         System.out.println("Found last " + searchForLast 
                           + " at index " + index);
      } 
      else {
         System.out.println(searchForLast + " not in the array");
      }
   }
}