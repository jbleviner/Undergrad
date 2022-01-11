

/**
 * MonitorsExample -- This example is intended to illustrate
 * the capabilities of the jGRASP "Monitor Info" viewer.
 *
 * Click the "Run in Canvas" button on the toolbar. Then on
 * the canvas window, click the "Play" button. You'll see the
 * other threads queuing up whenever the main thread enters
 * the synchronized block. Hit the "Pause" button when the
 * main thread is inside the synchronized block to see all
 * of the other threads queue up.
 *
 * To create your own canvas, click the "Pause" button on the
 * canvas.  Then on the Debug tab click the "Open Canvas" button.
 * Click the "Step" and Step-in" buttons as needed until you
 * see objects and primitives of interest in the Variables tab
 * and then drag them onto the canvas. Arrange the viewers and
 * click the "Play" button.
 */
public class MonitorsExample {

   /** Synchronization object. */
   private static Object sync = new Object();

   public static void main(final String[] args) {

      for (int i = 0; i < 10; i++) {
         Runnable r =
            new Runnable() {
               public void run() {
                  go();
               }
            };
         Thread tr = new Thread(r);
         tr.setName("Thread " + i);
         tr.start();
      }
      for (int i = 0; i < 100; i++) {
         synchronized (sync) {
            try {
               Thread.sleep(50);
            }
            catch (InterruptedException e) {
            }
         }
      }
   }


   public static void go() {

      while (true) {
         synchronized (sync) {
            try {
               Thread.sleep(50);
            }
            catch (InterruptedException e) {
            }
         }
         try {
            for (int i = 0; i < 10 + Math.random() * 150; i++) {
               Thread.sleep(100);
            }
         }
         catch (InterruptedException e) {
         }
      }
   }
}