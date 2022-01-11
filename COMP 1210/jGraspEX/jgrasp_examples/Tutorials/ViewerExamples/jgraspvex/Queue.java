package jgraspvex;


public class Queue {

   private Object[] elements = new Object[5];

   private int start;

   private int end;


   public void add(Object v) {
      elements[end++] = v;
      if (end == elements.length) {
         end = 0;
      }
      if (end == start) {
         Object[] newElements = new Object[elements.length * 2];
         if (start < end) {
            System.arraycopy(elements, start, newElements, 0,
                  end - start);
         }
         else {
            System.arraycopy(elements, start, newElements, 0,
                  elements.length - start);
            System.arraycopy(elements, 0, newElements,
                  elements.length - start, end);
         }
         if (end > start) {
            end = end - start;
         }
         else {
            end = elements.length - start + end;
         }
         elements = newElements;
         start = 0;
      }
   }


   public Object remove() {
      Object result = elements[start];
      elements[start] = null;
      //start++;
      start = (start + 1) % elements.length;
      return result;
   }

   public void clear() {
      elements = new Object[10];
      start = 0;
      end = 0;
   }
   
   public String toString() {
      return java.util.Arrays.toString(this.elements);
   }
}