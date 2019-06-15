package roundabout;

public class Node {

    private int id;
    private NodeType type;

    private Edge previous;
    private Edge next;

    public Node(int id, NodeType type) {
        this.id = id;
        this.type = type;
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
}
