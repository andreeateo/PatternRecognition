
import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author andreea teodor
 */
public class PointTest {

    public PointTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Point.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Point instance = new Point(0, 0);
        String expResult = "(0.0, 0.0)";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Point.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        int expResult = 0;
        int result = b.compareTo(a);
        assertEquals(expResult, result); //same coord

        Point c = new Point(5, 8);
        Point d = new Point(10, 7);
        expResult = -1;
        result = d.compareTo(c);
        assertEquals(expResult, result); // different y
        
        Point e = new Point(5, 8);
        Point f = new Point(10, 8);
        expResult = 1;
        result = f.compareTo(e);
        assertEquals(expResult, result); // break ties by x
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeTo() {
        System.out.println("slopeTo");
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double expResult = Double.NEGATIVE_INFINITY;
        double result = b.slopeTo(a);
        assertEquals(expResult, result, 0.0); //same coord

        Point c = new Point(10, 15);
        Point d = new Point(12, 25);
        expResult = 5;
        result = c.slopeTo(d);
        assertEquals(expResult, result, 0.0); //random coord

        Point e = new Point(12, 15);
        Point f = new Point(12, 25);
        expResult = Double.POSITIVE_INFINITY;
        result = f.slopeTo(e);
        assertEquals(expResult, result, 0.0); //vertical line

        Point g = new Point(9, 25);
        Point h = new Point(4, 25);
        expResult = 0;
        result = h.slopeTo(g);
        assertEquals(expResult, result, 0.0); //horizontal line
    }

    /**
     * Test of slopeOrder method, of class Point.
     */
    @Test
    public void testSlopeOrder() {
        System.out.println("slopeOrder");
        ArrayList<Point> points = new ArrayList<>();
        Point origin = new Point(0, 0);
        Point a = new Point(5, 1);
        points.add(a);
        Point b = new Point(2, 3);
        points.add(b);
        Point c = new Point(4, 2);
        points.add(c);
        Collections.sort(points, origin.slopeOrder());
        assertSame(b, points.get(2));
    }
}
