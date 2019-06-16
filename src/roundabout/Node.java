package roundabout;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Node {

    private final int id;
    private final NodeType type;

    private Edge previous;
    private Edge next;

    private final ConcurrentLinkedQueue<Car> carsOnHold;

    public Node(int id, NodeType type) {
        this.id = id;
        this.type = type;
        this.carsOnHold = new ConcurrentLinkedQueue<>();
    }

    public int getId() {
        return this.id;
    }

    public Edge getNext() {
        return this.next;
    }

    public Edge getPrevious() {
        return this.previous;
    }

    public void setPrevious(Edge previous) {
        if(this.previous == null)
            this.previous = previous;
    }

    public void setNext(Edge next) {
        if(this.next == null)
            this.next = next;
    }

    public boolean isIn() {
        return NodeType.In.equals(type);
    }

    public boolean isOut() {
        return NodeType.Out.equals(type);
    }

    public void addCar(Car c){
        this.carsOnHold.add(c);
    }

    public boolean checkCar(Car c){
        return this.carsOnHold.peek() == c;
    }

    public Car removeCar() { return this.carsOnHold.poll(); }

    @Override
    public String toString() {
        return "Node " + id + " " + type;
    }
}
