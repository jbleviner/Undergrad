package jgraspvex;

public class AVLTree {

   private int size;

   private AVLTreeNode root;


   public AVLTree() {
   }


   public void add(Comparable value) {
      AVLTreeNode node = new AVLTreeNode(value);
      if (root == null) {
         root = node;
         root.parent = null;
         size++;
      }
      else {
         add(root, node);
      }
   }


   private void add(AVLTreeNode branch, AVLTreeNode node) {
      int cmp = branch.value.compareTo(node.value);
      if (cmp > 0) {
         if (branch.left == null) {
            branch.left = node;
            node.parent = branch;
            size++;
         }
         else {
            add(branch.left, node);
         }
         computeHeightAndBF(branch);
         balance(branch);
      }
      else if (cmp < 0) {
         if (branch.right == null) {
            branch.right = node;
            node.parent = branch;
            size++;
         }
         else {
            add(branch.right, node);
         }
         computeHeightAndBF(branch);
         balance(branch);
      }
   }


   public void balance(AVLTreeNode node) {
      if (node.height < 2) {
         return;
      }
      if (height(node.left) > height(node.right) + 1) {
         boolean finish = false;
         AVLTreeNode left = node.left;
         if (height(left.left) < height(left.right)) {
            // First half of left-right rotation.
            AVLTreeNode tmp = left.right.left;
            node.left = left.right;
            left.right.parent = node;
            node.left.left = left;
            left.parent = node.left;
            node.left.left.right = tmp;
            if (tmp != null) {
               tmp.parent = node.left.left;
            }
            finish = true;
            computeHeightAndBF(node.left.left);
            computeHeightAndBF(node.left);
            left = node.left;
         }
         if (finish || height(left.left) > height(left.right)) {
            // Right rotation.
            AVLTreeNode tmp = left.right;
            AVLTreeNode parent = node.parent;
            left.right = node;
            node.parent = left;
            node.left = tmp;
            if (tmp != null) {
               tmp.parent = node;
            }
            if (parent == null) {
               root = left;
            }
            else if (parent.left == node) {
               parent.left = left;
            }
            else if (parent.right == node) {
               parent.right = left;
            }
            left.parent = parent;
            computeHeightAndBF(node);
            computeHeightAndBF(left);
         }
      }
      else if (height(node.right) > height(node.left) + 1) {
         boolean finish = false;
         AVLTreeNode right = node.right;
         if (height(right.right) < height(right.left)) {
            // First half of right-left rotation.
            AVLTreeNode tmp = right.left.right;
            node.right = right.left;
            right.left.parent = node;
            node.right.right = right;
            right.parent = node.right;
            node.right.right.left = tmp;
            if (tmp != null) {
               tmp.parent = node.right.right;
            }
            finish = true;
            computeHeightAndBF(node.right.right);
            computeHeightAndBF(node.right);
            right = node.right;
         }
         if (finish || height(right.right) > height(right.left)) {
            // Left rotation.
            AVLTreeNode tmp = right.left;
            AVLTreeNode parent = node.parent;
            right.left = node;
            node.parent = right;
            node.right = tmp;
            if (tmp != null) {
               tmp.parent = node;
            }
            if (parent == null) {
               root = right;
            }
            else if (parent.right == node) {
               parent.right = right;
            }
            else if (parent.left == node) {
               parent.left = right;
            }
            right.parent = parent;
            computeHeightAndBF(node);
            computeHeightAndBF(right);
         }
      }
      else {
         computeHeightAndBF(node);
      }
   }


   private void computeHeightAndBF(AVLTreeNode node) {
      node.height = 1 + Math.max(height(node.left),
            height(node.right));
      node.balanceFactor = height(node.right) - height(node.left);
   }


   private int height(AVLTreeNode node) {
      if (node == null) {
         return -1;
      }
      return node.height;
   }


   public int size() {
      return size;
   }
}

