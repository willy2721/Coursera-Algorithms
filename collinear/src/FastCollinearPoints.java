import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
    
    private List<LineSegment> lineSegs = new ArrayList<>();
    private Point[] pointsCopy;
    private int pointLen;
    public void printPoints(Point somePoints[]){
        for(int i = 0; i < somePoints.length; i++){
            System.out.println(somePoints[i].toString());
        }
    }
        
    public FastCollinearPoints(Point[] points){         
     // Throw null pointer exception if array is null or any entry is null
        if(points == null || Arrays.asList(points).contains(null)){
            throw new java.lang.NullPointerException();
        }
        else{    
            // Copy the points and record the length
            pointsCopy = points.clone();
            pointLen = pointsCopy.length;
            
            // Sort the copy based on method in Point.java
            Arrays.sort(pointsCopy);
            // Throw illegal argument exception if some points are repeated
            for(int i = 0; i < pointLen - 1; i++){
                if(pointsCopy[i].compareTo(pointsCopy[i + 1]) == 0){
                    throw new java.lang.IllegalArgumentException();
                }
            }
            // Find collinear points
            for(int i = 0; i < pointLen; i++){                
                // Sort the copy of points by their slope with respect to the base
                Arrays.sort(pointsCopy,points[i].slopeOrder());
                int low = 1;
                int high = 2;
                int base = i;
                
                
                /* Test
                if(i == 0){
                    System.out.println(points[i].toString());
                    System.out.println();
                    Arrays.sort(pointsCopy,points[i].slopeOrder());
                }
                */
                           
            }
              
        }
        
    }
    public int numberOfSegments(){
        return 0;
    }
    
    public LineSegment[] segments(){
        return null;
    }
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        collinear.printPoints(collinear.pointsCopy);
        /*
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
     // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        */

    }

}
