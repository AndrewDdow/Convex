
import java.util.ArrayList;


public class Segment implements Figure {
    private R2Point p, q, task;
    public Segment(R2Point p, R2Point q, R2Point task) {
        this.p = p; 
        this.q = q;
        this.task = task;
    }
    @Override public Figure add(R2Point r, R2Point task) {
        if (R2Point.isTriangle(p, q, r)) return new Polygon(p, q, r, task);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    @Override public double perimeter() {
        return 2 * R2Point.distance(p, q);
    }
    @Override public double area() {
        return 0;
    }
    @Override public double result() {
        return R2Point.distance(task, p) + R2Point.distance(task, q);
    }
    @Override public ArrayList<R2Point[]> task() {
        return null;
    }
}
