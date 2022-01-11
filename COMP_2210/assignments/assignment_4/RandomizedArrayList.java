import java.util.Random;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* RandomizedArrayList.java
 * Defines a Randomized Array List using 
 * the RandomizedList interface.
 *
 * @author Kevin Bumgarner (kgb0022)
 * @version 03-05-2020
 * 
 */
 
public class RandomizedArrayList<T> implements RandomizedList<T> {

 //------------------------------ Fields ------------------------------//

   private T[] elements; 
   private int size; 
   private static final int DEFAULT_CAPACITY = 1;
 
 //--------------------------- Constructors ---------------------------//
 
 /* Creates a new RandomizedArrayList */
   public RandomizedArrayList() {
      this(DEFAULT_CAPACITY);
   }
 /* Creates a new RandomizedArrayList
  * 
  * @param capacityIn (int) - the capacity of array
  */
   @SuppressWarnings("unchecked")
   public RandomizedArrayList(int capacityIn) {
      elements = (T[]) new Object[capacityIn];
      size = 0;
   }
  
 //----------------------------- Methods ------------------------------// 
 
 /* Returns size of elements.
  * @return size - size of elements
  */
   public int size() {
      return size;
   }
   
   
 /* Returns true if elements is full, false otherwise.
  *
  * @return boolean - based on size and capacity
  */
   public boolean isFull() {
      return size == elements.length;
   }
   
   
 /* Returns true if elements is empty, false otherwise.
  * @return boolean - based on size 
  */ 
   public boolean isEmpty() {
      return size == 0;
   }
   
   
 /* Resizes Elements.
  *
  * @param capacityIn (int) - the desired size of the new Array 
  */
   @SuppressWarnings("unchecked")
   private void resize(int capacityIn) {
      assert capacityIn > 0;
      T[] elementsCopy = (T[]) new Object[capacityIn];
      System.arraycopy(elements, 0, elementsCopy, 0, elements.length);
      elements = elementsCopy;
   }
   
 
 /* Adds the specified element to this list. If the element is null, this
  * method throws an IllegalArgumentException.
  *
  * @param elementIn ((T) Generic) - an element in the Array
  */
   public void add(T elementIn) {
      if (elementIn == null) {
         throw new IllegalArgumentException();
      }
      if (isFull()) {
         resize(elements.length * 2);
      }
      elements[size] = elementIn;
      size++;
   }
   
 
 /* Selects and removes an element selected uniformly at random from the
  * elements currently in the list. If the list is empty this method returns
  * null.
  *
  * @return removedElement - returns element removed
  */
   public T remove() {
      if (isEmpty()) {
         return null;
      }
      Random ran = new Random();
      int ranIndex = ran.nextInt(size);
      T removedElement = elements[ranIndex];
      elements[ranIndex] = elements[--size];
      elements[size] = null;
      return removedElement;
   }
   
 
 /* Selects but does not remove an element selected uniformly at random from
  * the elements currently in the list. If the list is empty this method
  * return null.
  *
  * @return sample - returns sample element
  */
   public T sample() {
      if (isEmpty()) {
         return null;
      }
      Random ran = new Random();
      int ranIndex = ran.nextInt(size);
      T sample = elements[ranIndex];
      return sample;
   }
   
   
 /* Returns iterator of the generic type.
  *
  * @return ArrayIterator() - returns new ArrayIterator
  */
   @SuppressWarnings("unchecked")
   public Iterator<T> iterator() {
      return new ArrayIterator(elements, size);
   }
   
 //--------------------- Iterator (Sub Class)------------------------------//
   
   public class ArrayIterator<T> implements Iterator<T> {
     // Current Index ////
      private int current;
     // Elements /////////
      private T[] items;
     // Number of items //
      private int count;
   
     // Constructor
     
    /* Creates a new ArrayIterator.
     *
     * @param itemsIn ((T[]) - Generic Array) an Array of items
     * @param countIn (int) - size of the Array
     */
      @SuppressWarnings("unchecked")
      public ArrayIterator(T[] itemsIn, int sizeIn) {
         count = sizeIn;
         current = 0;
         
         items = (T[]) new Object[size];
         for (int i = 0; i < size; i++) {
            items[i] = itemsIn[i];
         }
         
         this.randomize();
      }
      
     // Methods //
    
    /* Returns true if there exists a next element in the iteration.
     *
     * @return boolean - returns true or false
     */
      public boolean hasNext() {
         return (current < count);
      }
      
      
    /* Returns the next element in the iteration.
     *
     * @return next ((T) Generic) - returns element of the generic type
     */
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T next = items[current];
         current++;
         return next;
      } 
      
    
    /* Remove, unsupported operation. */
      public void remove() {
         throw new UnsupportedOperationException();
      } 
    
    
    /* Rearanges items. */
      private void randomize() {
         Random ran = new Random();
         for (int i = 0; i < count; i++) {
            int randomIndex = ran.nextInt(count);
            T itemInSequence = items[i];
            items[i] = items[randomIndex];
            items[randomIndex] = itemInSequence;
         }
      }
   }  
}