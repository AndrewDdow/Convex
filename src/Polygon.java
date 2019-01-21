import java.util.ArrayList;

class Polygon extends Deq implements Figure {
    private double s, p, task;
    private R2Point taskPoint;
    private ArrayList<R2Point[]> points;
    public Polygon(R2Point a, R2Point b, R2Point c, R2Point taskPoint) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a);
            pushBack(c);
        } 
        else {
            pushFront(c);
            pushBack(a);
        }
        p = R2Point.distance(a, b) + R2Point.distance(b, c) + R2Point.distance(c, a);
        s = Math.abs(R2Point.area(a, b, c));
        task = Math.pow(R2Point.distance(taskPoint, a), 2) + Math.pow(R2Point.distance(taskPoint, b), 2) + Math.pow(R2Point.distance(taskPoint, c), 2);
        this.taskPoint = taskPoint;
    }
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.distance(a, b);
        s += Math.abs(R2Point.area(a, b, t));
        R2Point[] points = {a, b, t};
        this.points.add(points);
    }
    @Override public Figure add(R2Point t, R2Point task) {
        int i;
        points = new ArrayList<>();
        for (i = length(); i > 0 && !t.light(back(), front()); i--) pushBack(popFront());
        if (i > 0) {
            R2Point x;
            grow(back(), front(), t);
            this.task += Math.pow(R2Point.distance(taskPoint, t), 2);
            for (x = popFront(); t.light(x, front()); x = popFront()) {
                grow(x, front(), t);
                this.task -= Math.pow(R2Point.distance(taskPoint, x), 2);
            }
            pushFront(x);
            //this.task += Math.pow(R2Point.distance(taskPoint, front()), 2);
            for (x = popBack(); t.light(back(), x); x = popBack()) {
                grow(back(), x, t);
                this.task -= Math.pow(R2Point.distance(taskPoint, x), 2);
            }
            pushBack(x);
            //this.task += Math.pow(R2Point.distance(taskPoint, back()), 2);
            p += R2Point.distance(back(), t) + R2Point.distance(t, front());
            pushFront(t);
            this.task += Math.pow(R2Point.distance(taskPoint, front()), 2);
        }
        return this;
    }
    @Override public double perimeter() {
        return p;
    }
    @Override public double area() {
        return s;
    }
    @Override public double result() {
        return task;
    }
    @Override public ArrayList<R2Point[]> task() {
        return points;
    }
}
