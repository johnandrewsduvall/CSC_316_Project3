/**
 * @author Matthew Watkins
 */

import java.util.*;

public class Vertex<E> {
    public E key;
    public LinkedList<Vertex<E>> neighbors;
    public UUID visitID;
    public int cumulativeLen;

    public Vertex(E key) {
        this.key = key;
        this.neighbors = new LinkedList<>();
        this.cumulativeLen = 0;
    }
}