import jgraspvex.BinaryTree;

/**
* BinaryTreeExample - This example is intended to illustrate the
* the capabilities of the Presentation Structure Identifier
* rendering of a binary search tree structure in the viewer canvas.
*
* Click the "Run in Canvas" button on the toolbar. Then on
* the canvas window, click the "Play" button. Regulate the
* speed with the "Delay" slider.
*
* To end the program, click the "Stop" button on the canvas
* or click the "End" button on the Run I/O tab.
*
* To create your own canvas, click the "Pause" button on the
* canvas.  Then on the Debug tab click the "Open Canvas" button.
* Click the "Step" and Step-in" buttons as needed until you
* see objects and primitives of interest in the Variables tab
* and then drag them onto the canvas. Arrange the viewers and
* click the "Play" button.
*/
public class BinaryTreeExample {

   /** Unsorted test values. */
   private static int[] values = { 5, 9, 12, 3, 22, 1, 17,
         4, 8, 11 };

   /** Sorted test values. */
   private static int[] sortedValues = { 1, 3, 4, 5, 8, 9,
         11, 12, 17, 22 };


   /**
    * Runs the example.
    *
    * @param args command line arguments, which are ignored.
    */
   public static void main(String[] args) {
      // To view the following int array as a binary tree
      // using the structure identifier viewer, choose the binary tree
      // structure and use expressions:
      //   Root Node:  (_tree_.length > 0)?0:-1
      //   Left Node:  _tree_[_node_]
      //   Right Node:  _tree_[_node_ + 1]
      //   Value: _tree_[_node_ + 2]
      int[] ia = new int[] { 3, 6, 0, -1, -1, 1, 9, 12,
            7, -1, -1, 5, -1, -1, 10 };
      ia = new int[] { 3, 6, 0, -1, -1, 1, 12, 9,
            7, -1, -1, 5, -1, -1, 10 };
   
      while (true) {
         BinaryTree bt = new BinaryTree();
         for (int i = 0; i < values.length; i++) {
            System.out.println("Add: " + values[i]);
            bt.add(new Integer(values[i]));
         }
         for (int i = 0; i < sortedValues.length; i++) {
            System.out.println("Remove: " + sortedValues[i]);
            bt.remove(new Integer(sortedValues[i]));
         }
      }
   }
}
