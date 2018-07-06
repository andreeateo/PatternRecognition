
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author andreea teodor
 */
public class FastCollinearPointsTest {

    public FastCollinearPointsTest() {
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
     * Test of checkDuplicatePoints method, of class FastCollinearPoints.
     */
    @Test
    public void testCheckDuplicatePoints() {
        System.out.println("checkDuplicatePoints");

        {
            Point[] points = new Point[2];
            points[0] = new Point(10000, 0);
            points[1] = new Point(0, 10000);

            FastCollinearPoints.checkDuplicatePoints(points);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDuplicatePointsException() {
        System.out.println("checkDuplicatePoints where present");
        {
            Point[] dpPoints = new Point[3];
            dpPoints[0] = new Point(10000, 0);
            dpPoints[1] = new Point(0, 10000);
            dpPoints[2] = new Point(10000, 0);

            FastCollinearPoints.checkDuplicatePoints(dpPoints);

        }
    }
}


