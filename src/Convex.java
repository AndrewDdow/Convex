
import java.awt.Graphics;


public class Convex {
    private Figure figure;
    private R2Point task;
    private R2Point task2;
    private Drawer drawer = new Drawer();
    public Convex() {
        figure = new Void();
    }
    public void add(R2Point point) {
        if (figure instanceof Polygon) {
            figure = figure.add(point, task);
            for (int i = 0; figure.task().size() > i; i++) drawer.addPolygon(figure.task().get(i));
        } else {
            figure = figure.add(point, task);
            drawer.addPoint(point);
            if (figure instanceof Segment || figure instanceof Polygon) drawer.repaint();
        }
    }
    public double area() {
        return figure.area();
    }
    public double perimeter() {
        return figure.perimeter();
    }
    public double result() {
        return figure.result();
    }
    public void task(R2Point task, R2Point task2) {
        this.task = task;
        this.task2 = task2;
    }
}