
public class LineSegment {
    private final Point p;   // one endpoint of the line segment
    private final Point q;   // the other endpoint of the line segment

   
    public LineSegment(Point p, Point q) {
        if (p == null || q == null) {
            throw new NullPointerException("argument is null");
        }
        this.p = p;
        this.q = q;
    }
    
    public void draw() {
        p.drawTo(q);
    }

    
    @Override
    public String toString() {
        return p + " -> " + q;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

}
