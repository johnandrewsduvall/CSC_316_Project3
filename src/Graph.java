import java.util.*;

public class Graph<E> {
    private TreeMap<E, Node<E>> _nodes = new TreeMap<E, Node<E>>();

    public Node<E> add(E val) {
        return add(new Node<E>(val));
    }

    public Node<E> add(Node<E> node) {
        _nodes.put(node.value, node);
        return node;
    }

    public boolean contains(E val) {
        return _nodes.containsKey(val);
    }

    public Node<E> get(E val) {
        return _nodes.get(val);
    }
}