
import java.util.ArrayList;


public class Point implements Figure {
    private R2Point p, task;
    public Point(R2Point p, R2Point task) {
        this.p = p;
        this.task = task;
    }
    @Override public Figure add(R2Point q, R2Point task) {
        if (!R2Point.equal(p, q)) return new Segment(p, q, task);
        else return this;
    }
    @Override public double perimeter() {
        return 0;
    }
    @Override public double area() {
        return 0;
    }
    @Override public double result() {
        return Math.pow(R2Point.distance(p, task), 2);
    }
    @Override public ArrayList<R2Point[]> task() {
        return null;
    }
}