import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Defines a DoubleEndedLinkedList using the
 * DoubleEndedList interface.
 *
 * @author Kevin Bumgarner (kgb0022@auburn.edu)
 * @version 03-06-2020
 */
public class DoubleEndedLinkedList<T> implements DoubleEndedList<T> {

//----------------- Fields --------------------//
   // Size of List
   private int size;
   // First Node in List
   private Node first;
   // Last Node in List
   private Node last;
   
//---------------- Constructor ----------------//

 /* Creates a DoubleEndedLinkedList. */
   public DoubleEndedLinkedList() {
      size = 0;
   }
   
//----------------- Methods -------------------//

 /* Returns size of linked list.
  *
  * @return size (int) - returns size
  */
   public int size() {
      return size;
   }

 
 /* Returns true if list is empty.
  *
  * @return boolean - returns boolean
  */
   public boolean isEmpty() {
      return size == 0;
   }
   
   
 /* Returns Iterator of the Generic type.
  *
  * @return LinkedIterator ((T) Generic) - returns an Iterator
  */
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }
   
   
 /*
  * Adds element to the front of the list. If element is null,
  * this method throws an IllegalArgumentException.
  *
  * @param elementIn ((T) Generic) - Element to be added
  */
   public void addFirst(T elementIn) {
      if (elementIn == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(elementIn);
      
      if (isEmpty()) {
         first = n;
         last = first;
      } else {
         n.next = first;
         first.prev = n;
         first = n;
      }
      size++;
   }
   
   
 /*
  * Adds element to the end of the list. If element is null,
  * this method throws an IllegalArgumentException.
  *
  * @param elementIn ((T) Generic) - Element to be added
  */
   public void addLast(T elementIn) {
      if (elementIn == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(elementIn);
      
      if (isEmpty()) {
         first = n;
         last = first;
      } else {
         n.prev = last;
         last.next = n;
         last = n;
      }
      size++;
   }
    
      
 /*
  * Delete and return the element at the front of the list.
  * If the list is empty, this method returns null.
  *
  * @return removed ((T) Generic) - returns removed element
  */
   public T removeFirst() {
      if (isEmpty()) {
         return null;
      } 
      T removed = first.element;
      if (size == 1) {
         first = null;
         last = null;
      } else {
         first = first.next;
         first.prev = null;
      }
      size--;
      return removed;
   }
  
   
 /*
  * Delete and return the element at the end of the list.
  * If the list is empty, this method returns null.
  *
  * @return removed ((T) Generic) - returns removed element
  */
   public T removeLast() {
      if (isEmpty()) {
         return null;
      } 
      T removed = last.element;
      if (size == 1) {
         first = null;
         last = null;
      } else {
         last = last.prev;
         last.next = null;
      }
      size--;
      return removed;
   }
   
   
//-------------- Node (Nested Class) -----------//

   private class Node {
      // Element in Node
      private T element;
      // Reference to Next Node
      private Node next;
      // Reference to Previous Node
      private Node prev;
      
      
      /* Creates a new Node.
       *
       * @param elementIn ((T) Generic) - Element in Node
       */
      public Node(T elementIn) {
         element = elementIn;
      }
   }
   
//------------- Iterator (SubClass) -----------//

   public class LinkedIterator implements Iterator<T> {
   // Current Node in iteration sequence //
      private Node current = first;
   
   /* Returns true if a value exists after the current Node
    * the Iteration sequence.
    *
    * @return boolean - based on method definition
    */
      public boolean hasNext() {
         return current != null;
      }
   
   
   /* Returns next Node in iteration sequence.
    *
    * @return nextElement ((T) Generic) - returns next element
    */
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T nextElement = current.element;
         current = current.next;
         return nextElement;
      }
      
      
   /* Remove, unsupported operation. */
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}