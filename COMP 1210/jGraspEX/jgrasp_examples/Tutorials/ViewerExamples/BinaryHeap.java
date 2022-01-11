/**
 * BinaryHeap.java -- This example is intended to illustrate
 * the capabilities of the Presentation Structure Identifier
 * rendering of a "heap" structure in the viewer canvas.  
 * 
 * Click the "Run in Canvas" button on the toolbar. Then on 
 * the canvas window, click the "Play" button. Regulate the 
 * speed with the "Delay" slider.
 * 
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you 
 * see objects and primitives of interest in the Variables tab 
 * and then drag them onto the canvas. Arrange the viewers and 
 * click the "Play" button.
 */
public class BinaryHeap {

   private Comparable[] heap;
   
   private int size;

   public BinaryHeap() {
      heap = new Comparable[20];
      size = 0;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public int size() {
      return size;
   }

   public Comparable getMax() {
      return (size == 0)? null : heap[1];
   }

   public void add(Comparable element) {
      if (size == heap.length - 1) {
         Comparable[] newHeap = new Comparable[heap.length * 2];
         System.arraycopy(heap, 0, newHeap, 0, heap.length);
         heap = newHeap;
      }
      size++;
      int pos = size;
      while (pos != 1 && heap[pos / 2].compareTo(element) < 0) {
         // Move parent down.
         heap[pos] = heap[pos / 2];
         pos /= 2;
      }
   
      heap[pos] = element;
   }

   public Comparable remove() {
      if (size == 0) {
         return null;
      }
      Comparable max = heap[1];
   
      Comparable last = heap[size--];
   
      int node = 1;
      int child = 2;
      while (child <= size) {
         if (child < size
               && heap[child].compareTo(heap[child + 1]) < 0) {
            child++;
         }
         if (last.compareTo(heap[child]) >= 0) {
            break;
         }
         // Move child up.
         heap[node] = heap[child];
         node = child;
         child *= 2;
      }
      heap[node] = last;
   
      return max;
   }

   public static void main(String [] args) {
      BinaryHeap hp = new BinaryHeap();
      Object ot = hp;
      System.out.println("Binary Heap Example");
      System.out.println("Add: C");
      hp.add("C");
      System.out.println("Add: D");
      hp.add("D");
      System.out.println("Add: b");
      hp.add("b");
      System.out.println("Add: a");
      hp.add("a");
      System.out.println("Add: C");
      hp.add("C");
      System.out.println("Remove");
      hp.remove();
      System.out.println("Add: z");
      hp.add("z");
      System.out.println("Remove");
      hp.remove();
      System.out.println("Add: k");
      hp.add("k");
   }
}
