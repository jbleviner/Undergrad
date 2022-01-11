package jgraspvex;


import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList extends AbstractSequentialList {
 
 
   private class Iter implements ListIterator {
   
      private int next;
      
      private LinkedNode prevNode;
      
      private int targetNext = -1;
   
   
      public Iter(int nextIn) {
         next = nextIn;
         prevNode = getPrev(next);
      }
      
      
      public void add(Object value) {
         LinkedList.this.add(next, value);
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
         if (prevNode == null) {
            prevNode = head;
         }
         else {
            prevNode = prevNode.next;
         }
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
         prevNode = getPrev(next);
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
            prevNode = getPrev(next);
         }
         LinkedList.this.remove(targetNext);
      }
      
      
      public void set(Object value) {
         if (targetNext < 0) {
            throw new IllegalStateException();
         }
         LinkedList.this.set(targetNext, value);
      }
   }


   private int size; 

   private LinkedNode head;


   public LinkedList() {
   }


   public boolean add(Object value) {
      add(size, value);
      return true;
   }


   public void add(int index, Object value) {
   
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException();
      }
      
      LinkedNode node = new LinkedNode(value);
      if (index == 0) {
         node.next = head;
         head = node;
      }
      else {
         LinkedNode prev = getPrev(index);
         node.next = prev.next;
         prev.next = node;
      }
   
      size++;
   }
   

   private LinkedNode getPrev(int index) {
      if (index == 0) {
         return null;
      }
      LinkedNode prev = head;
      for (int i = 1; i < index; i++) {
         prev = prev.next;
      }
      return prev;
   }


   public Object remove(int index) {
      if (index == 0) {
         Object result = head;
         size--;
         head = head.next;
         return head;
      }
      LinkedNode prev = getPrev(index);
      Object result = prev.next;
      size--;
      prev.next = prev.next.next;
      return result;
   }
   
   
   public int size() {
      return size;
   }


   public Object get(int index) {
      LinkedNode node = head;
      for (int i = 0; i < index; i++) {
         node = node.next;
      }
      return node.value;
   }
   
   
   public void selectionSort() {
      LinkedNode pos = null;
      LinkedNode posPrev = null;
      LinkedNode scan = null;
      LinkedNode scanPrev = null;
      LinkedNode min = null;
      LinkedNode minPrev = null;
      for (pos = head; pos != null; pos = pos.next) {
         min = pos;
         scanPrev = min;
         for (scan = min.next; scan != null; scan = scan.next) {
            Comparable c1 = (Comparable) min.value;
            Comparable c2 = (Comparable) scan.value;
            if (c2.compareTo(c1) < 0) {
               min = scan;
               minPrev = scanPrev;
            }
            scanPrev = scan;
         }
         if (min != pos) {
            swap(min, minPrev, pos, posPrev);
            pos = min;
         }
         posPrev = pos;
      }   
   }


   public void swap(LinkedNode n1, LinkedNode n1Prev,
         LinkedNode n2, LinkedNode n2Prev) {
      LinkedNode tmp = null;
      if (n1Prev != n2 && n2Prev != n1) {
         // Swap non-adjacent nodes.
         if (n1Prev != null) {
            n1Prev.next = n2;
         }
         if (n2Prev != null) {
            n2Prev.next = n1;
         }
         tmp = n1.next;
         n1.next = n2.next;
         n2.next = tmp;
      }
      else {
         // Swap adjacent nodes.
         LinkedNode prev = (n1Prev == n2)? n2Prev : n1Prev;
         LinkedNode swap1 = (n1Prev == n2)? n2 : n1;
         LinkedNode swap2 = (n1Prev == n2)? n1 : n2;
         if (prev != null) {
            prev.next = swap2;
         }
         swap1.next = swap2.next;
         swap2.next = swap1;
      }
      if (head == n1) {
         head = n2;
      }
      if (head == n2) {
         head = n1;
      }
   }
   
   
   public void printValues() {
      LinkedNode node = head;
      while(node != null) {
         if (node != head) {
            System.out.print(", ");
         }
         System.out.print(node.value);
         node = node.next;
      }
   }


   public ListIterator listIterator(int index) {
      return new Iter(index);
   }
}

