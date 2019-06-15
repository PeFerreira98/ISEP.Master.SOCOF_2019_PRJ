package roundabout;

public class Edge {
    private Node start;
    private Node end;
    private boolean isBusy;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.isBusy = false;
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
}