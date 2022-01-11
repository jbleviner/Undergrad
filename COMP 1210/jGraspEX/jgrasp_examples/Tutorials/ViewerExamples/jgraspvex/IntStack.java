package jgraspvex;


public class IntStack {

   private int[] values = new int[5];

   private int size;


   public void push(int v) {
      if (size + 1 > values.length) {
         int[] newValues = new int[size * 2];
         System.arraycopy(values, 0, newValues, 0, values.length);
         values = newValues;
      }
   
      values[size++] = v;
   }


   public int pop() {
      return values[--size];
   }


   public void clear() {
      size = 0;
   }
}