import java.util.*;

public class Graph<E> {
    private TreeMap<E, Node<E>> _nodes = new TreeMap<E, Node<E>>();

    public Node<E> add(E val) throws Exception {
        return add(new Node<E>(val));
    }

    public Node<E> add(Node<E> node) throws Exception {
        if (_nodes.containsKey(node.value)) {
            throw new Exception(node.value + " is already in the graph");
        }
        _nodes.put(node.value, node);
        return node;
    }
}