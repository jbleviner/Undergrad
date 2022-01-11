import jgraspvex.AVLTree;

/**
 * AVLTreeExample -- This example is intended to illustrate
 * the capabilities of the animating binary tree viewer
 * in jGRASP when applied to an AVL tree.
 *
 * Click the "Run in Canvas" button. On the canvas window, click
 * the "Play" button. Regulate the speed with the "Delay" slider.
 *
 * To end the program, click the "Stop" button on the canvas
 * or click the "End" button on the Run I/O tab.
 *
 * To see AVL rotations "all at once", "End" the program.
 * Set a breakpoint on the line that starts with "avl_tree.add".
 * Click the "Debug" button and then "Resume" repeatedly.
 *
 * To create your own canvas, click the "Run in Canvas" button
 * or set a breakpoint and click the "Debug" button. Then on the
 * Debug tab click the "Open Canvas" button. Click "Step" or
 * "Step-in" until you see objects or primitives of interest in
 * the Debug Variables tab, then drag them onto the canvas.
 * Arrange and click the "Play" button. Alternatively, you can
 * click the "Step" and Step-in" buttons.
 */
public class AVLTreeExample {

   private static int[][] values = {
         // Show right rotation.
         { 10, 5, 15, 3, 7, 1 },
         // Show left rotation.
         { 10, 15, 5, 20, 12, 30 },
         // Show left-right rotation.
         { 10, 15, 2, 1, 4, 7 },
         // Show right-left rotation.
         { 10, 15, 2, 20, 12, 11 },
         // Larger example
         { 31, 19, 51, 59, 21, 34, 56, 12, 1, 2, 3, 94,
            59, 91, 7, 9, 43, 32, 61, 63, 65, 64, 62, 4,
            82, 79, 44, 45, 46, 48, 49, 50, 32, 24, 23, 26,
            22, 25, 27, 29, 28 } };

   public static void main(String[] args) {
      while (true) {
         for (int s = 0; s < values.length; s++) {
            int[] set = values[s];
            AVLTree avlTree = new AVLTree();
            for (int i = 0; i < set.length; i++) {
               System.out.println("Add: " + set[i]);
               avlTree.add(new Integer(set[i]));
            }
         }
      }
   }
}