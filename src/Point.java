
import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final double x;     // x-coordinate of this point
    private final double y;     // y-coordinate of this point

    public Point(double x, double y) { // constructs the point (x, y)
        this.x = x;
        this.y = y;
    }

    public void draw() { // draws this point
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) { // draws the line segment from this point to that point
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    @Override
    public String toString() { // string representation
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point that) { // compare two points by y-coordinates, breaking ties by x-coordinates
        if (this.y < that.y) {
            return -1;
        } else if (this.y > that.y) {
            return 1;
        } else {
            if (this.x < that.x) {
                return -1;
            } else if (this.x > that.x) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public double slopeTo(Point other) { // the slope between this point and that point
        if (this.y == other.y && this.x == other.x) {
            return Double.NEGATIVE_INFINITY;    //points are equal
        } else if (this.x == other.x) {
            return Double.POSITIVE_INFINITY;    //vertical line
        } else if (this.y == other.y) {
            return +0.0;                        //horizontal line
        } else {
            return (other.y - this.y) / (other.x - this.x);
        }
    }

    public Comparator<Point> slopeOrder() { // compare two points by slopes they make with this point
        Comparator<Point> comp = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double slope1 = slopeTo(o1);
                double slope2 = slopeTo(o2);
                if (slope1 < slope2) {
                    return -1;
                } else if (slope1 > slope2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        return comp;
    }

}
