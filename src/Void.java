
import java.util.ArrayList;



public class Void implements Figure {
    public Figure add(R2Point p, R2Point task) {
        return new Point(p, task);
    }
    @Override public double perimeter() {
        return 0;
    }
    @Override public double area() {
        return 0;
    }
    @Override public double result() {
        return 0;
    }
    @Override public ArrayList<R2Point[]> task() {
        return null;
    }
}
