package roundabout;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

    private int id;
    private NodeType type;

    private Edge previous;
    private Edge next;

    // private boolean hasCar;

    private Queue<Car> carsOnHold;

    public Node(int id, NodeType type) {
        this.id = id;
        this.type = type;
        this.carsOnHold = new LinkedList<Car>();
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

    public boolean isIn() {
        return NodeType.In.equals(type);
    }

    public boolean isOut() {
        return NodeType.Out.equals(type);
    }

    @Override
    public String toString() {
        return "Node " + id + " " + type;
    }

    public void setPrevious(Edge previous) {
        this.previous = previous;
    }

    public void setNext(Edge next) {
        this.next = next;
    }

    // public void setHasCar(boolean b){
    //     this.hasCar = b;
    // }

    // public boolean hasCar(){
    //     return this.hasCar;
    // }

    public void addCar(Car c){
        this.carsOnHold.add(c);
    }

    public boolean checkCar(Car c){
        return this.carsOnHold.peek().getId() == c.getId();
    }

    public Car removeCar(){
        return this.carsOnHold.poll();
    }
}
