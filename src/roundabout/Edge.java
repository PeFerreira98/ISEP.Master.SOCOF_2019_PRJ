package roundabout;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Edge {
    private final Node start;
    private final Node end;
    private final AtomicBoolean isBusy;
    private final AtomicReference<Car> currentCar;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.isBusy = new AtomicBoolean(false);
        this.currentCar = new AtomicReference<>();
    }

    public Node getStart() {
        return this.start;
    }

    public Node getEnd() {
        return this.end;
    }

    public Edge getNext() {
        return this.end.getNext();
    }

    public Edge getPrevious() {
        return this.start.getPrevious();
    }

    public boolean acquire() {
        return this.isBusy.compareAndSet(false, true);
    }

    public boolean acquire(Car c) {
        return this.currentCar.compareAndSet(null, c);
    }

    public boolean release() {
        //this.isBusy.set(false);
        return this.isBusy.compareAndSet(true, false);
    }

    public boolean release(Car c) {
        return this.currentCar.compareAndSet(c, null);
    }

    @Override
    public String toString() {
        return "Edge -> start: " + start.toString() + " end: " + end.toString();
    }
}