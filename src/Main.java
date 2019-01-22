
public class Main {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        System.out.println("Enter task and task2 point");
        convex.task(new R2Point(), new R2Point());
        while (true) {
            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = " + convex.perimeter() + " , task = " + convex.result());
        }
    }
}
