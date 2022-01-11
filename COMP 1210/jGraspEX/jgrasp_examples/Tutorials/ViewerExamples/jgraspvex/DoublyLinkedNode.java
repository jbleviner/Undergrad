package jgraspvex;


/** Doubly linked list example node class. */
public class DoublyLinkedNode {
   
   DoublyLinkedNode next;
   
   DoublyLinkedNode prev;
   
   Object value;


   public DoublyLinkedNode() {
   }

    
   public DoublyLinkedNode(Object initValue) {
      value = initValue;
   }


   public Object getValue() {
      return value;
   }


   public void setValue(Object newValue) {
      value = newValue;
   }
}
