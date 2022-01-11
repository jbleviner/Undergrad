
import java.awt.BorderLayout;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * ComponentExample -- This example is intended to
 * illustrate the capabilities of the jGRASP viewers for
 * the Components. 
 * 
 * Click the "Run in Canvas" button on the toolbar. Then on 
 * the canvas window, click the "Play" button. Allow the
 * program to play to the end, at which point it will pause.
 * Ajust the size of the frame that pops up to see the effect
 * on the frame viewer. Select the frame viewer then move
 * the mouse across the windows shown there to see information
 * for the window under the mouse and all its ancestors.
 * 
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you 
 * see objects and primitives of interest in the Variables tab 
 * and then drag them onto the canvas. Arrange the viewers and 
 * click the "Play" button.
 */
public class ComponentExample {

   public static void main(String[] args) {
      JPanel panel = new JPanel(new BorderLayout(5, 5));
      JLabel l1 = new JLabel(" ");
      l1.setOpaque(true);
      panel.add(l1, "South");
      JPanel center = new JPanel();
      center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
      panel.add(center, "Center");
      JLabel l2 = new JLabel("1");
      l2.setOpaque(true);
      JLabel l3 = new JLabel("2");
      l3.setOpaque(true);
      center.add(l2);
      center.add(l3);
   
      JFrame frame = new JFrame();
   
      boolean b = true;
      Boolean bl = Boolean.TRUE;
      int i = 0xfffffff0;
      Integer it = new Integer(i);
   
      frame.setContentPane(panel);
      frame.setAlwaysOnTop(true);
      frame.pack();
      frame.setVisible(true);
      l1.setBackground(Color.WHITE);
      center.setBackground(Color.RED);
      l2.setBackground(Color.GREEN);
      l3.setBackground(Color.CYAN);
   }

}
