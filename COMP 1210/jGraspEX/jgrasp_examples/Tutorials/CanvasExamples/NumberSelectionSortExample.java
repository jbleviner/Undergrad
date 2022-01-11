
/** 
 * NumberSelectionSortExample - This example is intended 
 * to illustrate the capabilities of Bar Graph viewer and 
 * the Presentation Structure Identifier rendering of an 
 * array of Doubles with index variables.
 *  
 * Click the "Run in Canvas" button on the toolbar. Then on 
 * the canvas window, click the "Play" button. Regulate the 
 * speed with the "Delay" slider. 
 */
public class NumberSelectionSortExample {

   /** 
    * Populates an array with random Doubles then sorts
    * the array using selection sort.
    *
    * @param args command line arguments, which are ignored. 
    */
   public static void main(String[] args) {
      double[] ia = new double[10];
      for (int i = 0; i < 10; i++) {
         ia[i] = (double) (Math.random() * 10 - 5);
      }
      
      selectionSort(ia);
      
      for (double i : ia) {
         System.out.println(i);
      }
   }

   /** 
    * Sorts an array of type double using selection sort.
    *
    * @param list the double array to be sorted. 
    */   
   static void selectionSort(double[] list) {
      int min;
      double temp;
   
      for (int index = 0; index < list.length - 1; index++) {
         min = index;
         for (int scan = index + 1; scan < list.length; scan++) {
            if (list[scan] < list[min]) {
               min = scan;
            }
         }
      
         // Swap the values.
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }
}