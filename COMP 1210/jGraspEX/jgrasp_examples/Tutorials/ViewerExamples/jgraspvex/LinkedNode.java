package jgraspvex;


/** Linked list example node class. */
public class LinkedNode {
   
   LinkedNode next;
   
   Object value;


   public LinkedNode() {
   }

    
   public LinkedNode(Object initValue) {
      value = initValue;
   }


   public Object getValue() {
      return value;
   }


   public void setValue(Object newValue) {
      value = newValue;
   }
}
