package jgraspvex;


import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList extends AbstractSequentialList {


   private class Iter implements ListIterator {
   
      private int next;
      
      private DoublyLinkedNode prevNode;
      
      private int targetNext = -1;
   
   
      public Iter(int nextIn) {
         next = nextIn;
         prevNode = getPrev(next);
      }
      
      
      public void add(Object value) {
         DoublyLinkedList.this.add(next, value);
         next++;
         prevNode = prevNode.next;
         targetNext = -1;
      }
   
   
      public boolean hasNext() {
         return next < size;
      }
      
      
      public boolean hasPrevious() {
         return next > 0;
      }
      
      
      public Object next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         targetNext = next;
         next++;
         prevNode = prevNode.next;
         return prevNode.value;
      }
      
      
      public int nextIndex() {
         return next;
      }
      
      
      public Object previous() {
         if (!hasPrevious()) {
            throw new NoSuchElementException();
         }
         targetNext = next - 1;
         next--;
         Object result = prevNode.value;
         prevNode = prevNode.prev;
         return result;
      }
      
      
      public int previousIndex() {
         return next - 1;
      }
      
      
      public void remove() {
         if (targetNext < 0) {
            throw new IllegalStateException();
         }
         if (targetNext < next) {
            next--;
            prevNode = prevNode.prev;
         }
         DoublyLinkedList.this.remove(targetNext);
      }
      
      
      public void set(Object value) {
         if (targetNext < 0) {
            throw new IllegalStateException();
         }
         DoublyLinkedList.this.set(targetNext, value);
      }
   }

 
   private int size; 

   private DoublyLinkedNode head;
   
   private DoublyLinkedNode tail;


   public DoublyLinkedList() {
   }


   public boolean add(Object value) {
      add(size, value);
      return true;
   }


   public void add(int index, Object value) throws IndexOutOfBoundsException {
   
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException();
      }
   
      DoublyLinkedNode node = new DoublyLinkedNode(value);
      if (head == null) {
         node.next = node;
         node.prev = node;
         tail = node;
      }
      else {
         DoublyLinkedNode prev = getPrev(index);
         node.next = prev.next;
         node.prev = prev;
         node.next.prev = node;
         prev.next = node;
      }
      if (index == 0) {
         head = node;
      }
      if (index == size) {
         tail = node;
      }
      
      size++;
   }
   
   
   private DoublyLinkedNode getPrev(int index) {
      DoublyLinkedNode prev = tail;
      if (index < size / 2) {
         for (int i = 0; i < index; i++) {
            prev = prev.next;
         }
      }
      else {
         for (int i = size; i > index; i--) {
            prev = prev.prev;
         }
      }
      return prev;
   }
   

   public Object remove(int index) throws IndexOutOfBoundsException {
   
      if (index < 0 || index > size - 1) {
         throw new IndexOutOfBoundsException();
      }
   
      if (size == 1) {
         Object result = head;
         head = null;
         tail = null;
         size--;
         return result;
      }
    
      DoublyLinkedNode prev = getPrev(index);
      Object result = prev.next;
      prev.next = prev.next.next;
      if (prev.next != null) {
         prev.next.prev = prev;
      }
      if (index == 0) {
         head = prev.next;
      }
      if (index == size - 1) {
         tail = prev;
      }
      size--;
      return result;
   }
   
   
   public int size() {
      return size;
   }


   public Object get(int index) throws IndexOutOfBoundsException {
      if (index < 0 || index > size - 1) {
         throw new IndexOutOfBoundsException();
      }
      return getPrev(index).next.value;
   }
   
   
   public void selectionSort() {
      DoublyLinkedNode pos = null;
      DoublyLinkedNode scan = null;
      DoublyLinkedNode min = null;
      for (pos = head; pos != tail; pos = pos.next) {
         min = pos;
         for (scan = min.next; scan != head; scan = scan.next) {
            Comparable c1 = (Comparable) min.value;
            Comparable c2 = (Comparable) scan.value;
            if (c2.compareTo(c1) < 0) {
               min = scan;
            }
         }
         if (min == pos) {
            continue;
         }
         swap(min, pos);
         pos = min;
      }   
   }


   public void swap(DoublyLinkedNode n1, DoublyLinkedNode n2) {
      DoublyLinkedNode tmp = null;
      if (n1.next != n2 && n2.next != n1) {
         // Swap non-adjacent nodes.
         n1.prev.next = n2;
         n1.next.prev = n2;
         n2.prev.next = n1;
         n2.next.prev = n1;
         tmp = n1.next;
         n1.next = n2.next;
         n2.next = tmp;
         tmp = n1.prev;
         n1.prev = n2.prev;
         n2.prev = tmp;
      }
      else if (size != 2) {
         // Swap adjacent nodes.
         DoublyLinkedNode swap1 = (n1.next == n2)? n1 : n2;
         DoublyLinkedNode swap2 = (n1.next == n2)? n2 : n1;
         swap1.prev.next = swap2;
         swap2.next.prev = swap1;
         swap1.next = swap2.next;
         swap2.prev = swap1.prev;
         swap1.prev = swap2;
         swap2.next = swap1;
      }
      if (head == n1) {
         head = n2;
      }
      if (head == n2) {
         head = n1;
      }
      if (tail == n2) {
         tail = n1;
      }
      if (tail == n1) {
         tail = n2;
      }
   }
   
   
   public void printValues() {
      DoublyLinkedNode node = head;
      if (node == null) {
         return;
      }
      do {
         if (node != head) {
            System.out.print(", ");
         }
         System.out.print(node.value);
         node = node.next;
      } while (node != head);
   }


   public ListIterator listIterator(int index) {
      return new Iter(index);
   }
}

