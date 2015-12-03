import java.util.*;

public class Node<E> {
    public E value;
    public ArrayList<Node<E>> neighbors;

    public Node(E value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }
}