package jgraspvex;

/** AVL tree example node class. */
public class AVLTreeNode {
 
   AVLTreeNode left;
   
   AVLTreeNode right;
   
   AVLTreeNode parent;
   
   int height;
   
   int balanceFactor;
   
   Comparable value;


   public AVLTreeNode() {
   }

    
   public AVLTreeNode(Comparable initValue) {
      value = initValue;
   }


   public Object getValue() {
      return value;
   }
}
