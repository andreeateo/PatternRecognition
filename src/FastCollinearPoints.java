
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FastCollinearPoints {

    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points) { // finds all line segments containing 4 or more points
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException("Null point");
            }
        }
        checkDuplicatePoints(points);
        Arrays.sort(points);

        ArrayList<Point> peas = new ArrayList<>();
        ArrayList<LineSegment> foundSegments = new ArrayList<>();
        ArrayList<Point> collinearPoints = new ArrayList<>();

        for (int p = 0; p < points.length - 1; p++) { //take a point
            for (int q = p + 1; q < points.length; q++) { //iterate over the others
                peas.add(points[q]); //add them to an arrayList
            }
            Collections.sort(peas, points[p].slopeOrder()); //sort the ArrayList
            double slope = points[p].slopeTo(peas.get(0));
            collinearPoints.add(peas.get(0));
            for (int i = 1; i < peas.size(); i++) { //for every point in the sorted arrayList
                if (slope == points[p].slopeTo(peas.get(i))) {
                    collinearPoints.add(peas.get(i));
                } else if (slope != points[p].slopeTo(peas.get(i)) && collinearPoints.size() >= 3) {
                    Collections.sort(collinearPoints); 
                    foundSegments.add(new LineSegment(points[p], collinearPoints.get(collinearPoints.size() - 1)));
                    collinearPoints.clear();
                    slope = points[p].slopeTo(peas.get(i));
                    collinearPoints.add(peas.get(i));
                } else {
                    collinearPoints.clear();
                    slope = points[p].slopeTo(peas.get(i));
                    collinearPoints.add(peas.get(i));
                }
            }
            if (collinearPoints.size() >= 3) {
                    Collections.sort(collinearPoints); 
                    foundSegments.add(new LineSegment(points[p], collinearPoints.get(collinearPoints.size() - 1)));
            }
            collinearPoints.clear();
            peas.clear();
        }
        segments = new LineSegment[foundSegments.size()];
        foundSegments.toArray(segments);
    }

    public int numberOfSegments() { // the number of line segments
        return segments.length;
    }

    public LineSegment[] segments() { // the line segments
        return segments;
    }

    public static void checkDuplicatePoints(Point[] points) { //helper method
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate points");
                }
            }
        }
    }
}
