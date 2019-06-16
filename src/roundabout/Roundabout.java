package roundabout;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Roundabout {

    private final List<Node> nodes;

    public Roundabout (int accesses){
        if(accesses < 1)
            throw new InvalidParameterException("cannot create roundabout with less than 1 entries");

        this.nodes = new ArrayList<>();

        Node last = new Node(0, NodeType.In);
        this.nodes.add(last);
        Edge edge = null;

        for(int i = 1; i < 2 * accesses; i++) {
            Node newNode = new Node(i, i % 2 == 0 ? NodeType.In: NodeType.Out);
            this.nodes.add(newNode);
            edge = new Edge(last, newNode);
            newNode.setPrevious(edge);
            last.setNext(edge);
            last = newNode;
        }

        //Creating the final edge to "close" the roundabout
        edge = new Edge(last,nodes.get(0));

        last.setNext(edge);
        nodes.get(0).setPrevious(edge);
    }

    public boolean hasNode(Node node) {
        return nodes.contains(node);
    }

    public Node getNodeByIndex(int index){
        return this.nodes.get(index);
    }

    public Node getNode(Node node) {
        for (Node n : this.nodes) {
            if(n.getId() == node.getId()) {
                return n;
            }
        }

        return null;
    }

    public void PrintRoundabout(){
        System.out.println("ROUNDABOUT");
        for(Node n : this.nodes){
            System.out.println("\tNODE -> " + n.toString() + " -> ");

            if (n.getNext() != null)
                System.out.println("\t\tEDGE -> " + n.getNext().toString() + " -> ");
        }
    }
}
