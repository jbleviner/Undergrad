import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;


public class LineTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void constructorTest() {
      Point a = new Point(1,1);
      Point b = new Point(2,2);
      Point c = new Point(3,3);
      Point k = new Point(1,15);
      Point d = new Point(0,0);
      Point e = new Point(0,0);
      Point f = new Point(4,4);
      Point g = new Point(23,10);
     
      
      Collection<Point> c1 = Arrays.<Point>asList(new Point[]{a,b,c,d,e,f,g});
      
      Line l = new Line(c1);
      l.add(k);
      int expected = 5;
      int actual = l.length();
      
      Assert.assertEquals("test 1", expected, actual);
   }
}
