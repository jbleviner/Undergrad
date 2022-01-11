
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import java.util.Random;

import javax.swing.ImageIcon;

/**
 * ImageAndColorExample -- This example is intended to
 * illustrate the capabilities of the jGRASP viewers for
 * java.awt.Image, javax.swing.ImageIcon, and java.awt.Color.
 *
 * Click the "Run in Canvas" button on the toolbar. Then on
 * the canvas window, click the "Play" button. Regulate the
 * speed with the "Delay" slider.
 *
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you
 * see objects and primitives of interest in the Variables tab
 * and then drag them onto the canvas. Arrange the viewers and
 * click the "Play" button.
 *
 * To end the program, click the "Stop" button on the canvas
 * or click the "End" button on the Run I/O tab.
 *
 * Alternatively:
 * Set a breakpoint inside the inner loop and launch the
 * debugger. After program stops at the breakpoint, open
 * viewers on one or more variables by "dragging" the variable
 * out of the Debug tab and releasing it. Now hit resume to
 * perform one execution of the loop. With AutoResume turned
 * on, the debugger will repeatedly execute the loop when you
 * click the Resume button. Turning off AutoResume returns the
 * debugger to single resume mode.
 */
public class ImageAndColorExample {

   private static Image[] images;

   static {
      Toolkit tk = Toolkit.getDefaultToolkit();
      images = new Image[3];
      images[0] = tk.createImage("testimg.png");
      images[1] = tk.createImage("testimg2.png");
      images[2] = tk.createImage("testimg3.png");
      for (int i = 0; i < images.length; i++) {
         tk.prepareImage(images[i], -1, -1, null);
      }
   }

   private static Random random = new Random();


   public static void main(String[] args) {
      Image image = images[0];
      ImageIcon imageIcon = new ImageIcon(images[2]);
      Color color = new Color(random.nextInt());
   
      while (true) {
         for (int i = 0; i < images.length; i++) {
            image = images[(i + 1) % images.length];
            imageIcon.setImage(images[i]);
            color = new Color(random.nextInt());
         }
      }
   }
}