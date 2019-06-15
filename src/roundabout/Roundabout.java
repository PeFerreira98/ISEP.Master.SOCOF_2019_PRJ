package roundabout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Roundabout {
    private List<Node> nodes;

    /*
    private HashMap<Car, Tuple<Integer, Edge>> carsPosition;

    public class Tuple<K, V> {
        public final K key;
        public final V value;
        public Tuple(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
     */

    public Roundabout (int accesses){
        this.nodes = new ArrayList<>();

        Node last = new Node(0, NodeType.Out);
        this.nodes.add(last);
        Edge edge = null;

        for(int i = 1; i < 2 * accesses; i++) {
            Node newNode = new Node(i, i % 2 == 0 ? NodeType.In: NodeType.Out);
            this.nodes.add(newNode);
            edge = new Edge(last, newNode);
            newNode.setPrevious(edge);
            last.setNext(edge);
        }
        nodes.get(0).setPrevious(edge);
    }

    public boolean hasNode(Node node) {
        return nodes.contains(node);
    }
}