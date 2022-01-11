package jgraspvex;

/** Binary tree example node class. */
public class BinaryTreeNode {
   
   BinaryTreeNode left;
   
   BinaryTreeNode right;
   
   Comparable value;


   public BinaryTreeNode() {
   }

    
   public BinaryTreeNode(Comparable initValue) {
      value = initValue;
   }


   public Object getValue() {
      return value;
   }
}
