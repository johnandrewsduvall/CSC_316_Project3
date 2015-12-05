public class Vertex<E> {
    public E key;
    public LinkedList<Vertex<E>> neighbors;
    public int visitID;

    public Vertex(E key) {
        this.key = key;
        this.neighbors = new LinkedList<Vertex<E>>();
    }
}