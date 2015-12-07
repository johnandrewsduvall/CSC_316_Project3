/**
 * @author Matthew Watkins
 * Definition of Vertex Object for use in the UndirectedGraph Class
 */

import java.util.UUID;

public class Vertex<E> {
    /** key value */
    public E key;
    /** LinkedList of neighbors */
    public LinkedList<Vertex<E>> neighbors;
    /** visit ID */
    public UUID visitID;
    /** number of cumulative */
    public int cumulativeLen;

    /**
     * Constructor method
     * @param key
     */
    public Vertex(E key) {
        this.key = key;
        this.neighbors = new LinkedList<>();
        this.cumulativeLen = 0;
    }
}