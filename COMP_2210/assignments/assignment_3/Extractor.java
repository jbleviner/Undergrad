import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Kevin Bumgarner (kgb0022@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version Feb. 22, 2020
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename.
    *
    * @param filename (String) name of file to be read  
    */
   public Extractor(String filename) {
      try {
         File file = new File(filename);
         Scanner sc = new Scanner(file);
         int length = sc.nextInt();
         int x;
         int y;
      
         points = new Point[length];
         for (int i = 0; i < points.length; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            Point p = new Point(x,y);
            points[i] = p;
         }
      } catch(java.io.IOException e) {
         System.err.println("File " + filename + " could not be read");
      } 
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>(); // Place lines here
      Line line = new Line(); // Place collinear points here
      
      for (int i = 0; i < points.length; i++) { //Selects first point
         for (int j =  i + 1; j < points.length; j++) { //Selects second point
            for (int k = j + 1; k  < points.length; k++) { //Selects third point
               for (int l = k + 1; l < points.length; l++) { //Selects fourth point 
                  Point first = points[i];
                  Point second = points[j];
                  Point third = points[k];
                  Point fourth = points[l];
                  line.add(first);  // Attempts to 
                  line.add(second); // add all
                  line.add(third);  // selected
                  line.add(fourth); // points
                  if (line.length() == 4) {
                     lines.add(line);
                  }
                  line = new Line();
               }
            }
         }
      } 
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Line line = new Line();
      Point[] sortedP = Arrays.copyOf(points, points.length);
      boolean added = false;
      
      for (int i = 0; i < points.length; i++) { // Loops through unsorted array
         Arrays.sort(sortedP, points[i].slopeOrder); // Sorts original
         line.add(sortedP[0]); // Adds first point
         for (int j = 0; j < sortedP.length; j++) { // Loops through sorted array
            added = line.add(sortedP[j]); // Attempts to add point at index j
            if (!added) { // Point was not added
               if (line.length() >= 4) { // Line is >= 4 points 
                  lines.add(line);  
               }
               line = new Line(); // Creates new line
               line.add(sortedP[0]); // Adds first point
               line.add(sortedP[j]); // Adds second point
            }
         }
      } 
      return lines;
   }
   
}
