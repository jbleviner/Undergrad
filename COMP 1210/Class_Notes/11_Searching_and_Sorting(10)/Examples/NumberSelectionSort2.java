public class NumberSelectionSort2
{
   public static void main(String[] args)
   {
      Double[] ia = new Double[20];
      for (int i = 0; i < 20; i++)
      {
         ia[i] = (double) (Math.random() * 20 - 10);
      }
      Sorting<Double> sorts = new Sorting<Double>();
      sorts.selectionSort(ia);
      for (Double i : ia) {
         System.out.println(i);
      }
   }
}