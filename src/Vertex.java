/**
 * @author Matthew Watkins
 * Definition of Vertex Object for use in the UndirectedGraph Class
 */

import java.util.UUID;

/**
 *
 * @author JohnAndrew
 * @param <E>
 */
public class Vertex<E> {
    public E key;
    public LinkedList<Vertex<E>> neighbors;
    public UUID visitID;
    public int cumulativeLen;

    /**
     *
     * @param key
     */
    public Vertex(E key) {
        this.key = key;
        this.neighbors = new LinkedList<>();
        this.cumulativeLen = 0;
    }
}