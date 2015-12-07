/**
 * @author Matthew Watkins
 * An undirected graph and methods to work upon it; it can be made read only
 */

import java.util.LinkedHashMap;
import java.util.UUID;

public class UndirectedGraph<E> {
    // Prevents modification of graph after first query
    private boolean _readOnly = false;
    
    // The verices of the graph
    private LinkedHashMap<E, Vertex<E>> _vertices = new LinkedHashMap<>();

    // Cached outputs vars for the two methods (improves performance)
    private int _unconnectedPairs = -1;
    private LinkedList<E> _mostConnectedNodes = null;

    /**
     * Adds a vertex
     * @param key the key of the vertex to add
     * @throws Exception if the result if the graph is in read-only mode
     */
    public void addVertex(E key) throws Exception {
        checkReadOnlyMode();
        _vertices.put(key, new Vertex<>(key));
    }

    /**
     * Adds an undirected edge between two vertices
     * @param key1 the first key to map
     * @param key2 the second key ot map
     * @throws Exception if the result is invalid
     */
    public void addEdge(E key1, E key2) throws Exception {
        checkReadOnlyMode();
        Vertex<E> v1 = _vertices.get(key1);
        Vertex<E> v2 = _vertices.get(key2);
        v1.neighbors.append(v2);
        v2.neighbors.append(v1);
    }

    // Graph query methods

    /**
     * This method returns the boolean result of areNeighbors.
     * @param key1 the first key to query
     * @param key2 the seconsd key to query
     * @return true if there exists an edge between two vertices,
     * false otherwise
     */
    public boolean areNeighbors(E key1, E key2) {
        // Get the 1st vertex
        Vertex<E> v1 = _vertices.get(key1);
        if (v1.neighbors.size == 0) {
            return false;
        }

        // Get the 2nd vertex
        Vertex<E> v2;
        v2 = _vertices.get(key2);
        if (v2.neighbors.size == 0) {
            return false;
        }

        // See if any of 1's neighbors is 2
        LinkedListIterator<Vertex<E>> iterator = v1.neighbors.iterator();
        while (iterator.hasNext()) {
            Vertex<E> n = iterator.next();
            if (n == v2) {
                return true;
            }
        }

        // No match. Not neighbors
        return false;
    }

    /**
     * This method returns list of shared neighbors between two vertices.
     * @param key1 the first key to query
     * @param key2 the seconsd key to query
     * @return List of shared neighbors between two vertices
     */
    public LinkedList<E> getMutualNeighbors(E key1, E key2) {
        LinkedList<E> mutual = new LinkedList<>();

        // Get the 1st vertex neighbors
        LinkedList<Vertex<E>> n1 = _vertices.get(key1).neighbors;
        if (n1.size == 0) {
            return mutual;
        }

        // Get the 2nd vertex neighbors
        LinkedList<Vertex<E>> n2 = _vertices.get(key2).neighbors;
        if (n2.size == 0) {
            return mutual;
        }

        // Iterate over the vertices of vertex 1
        LinkedListIterator<Vertex<E>> n1It = n1.iterator();
        while (n1It.hasNext()) {
            Vertex<E> c1 = n1It.next();
            
            // Compare to the neighbors of vertex 2
            LinkedListIterator<Vertex<E>> n2It = n2.iterator();
            while (n2It.hasNext()) {
                Vertex<E> c2 = n2It.next();
                if (c1 == c2) {
                    // Found a mutual neighbor
                    mutual.append(c1.key);
                    break;
                }
            }
        }

        return mutual;
    }

    /**
     * This method returns the shortest path between two vertices.
     * @param key1 the first key to query
     * @param key2 the seconsd key to query
     * @return The shortest path between two vertices, returns an empty list is
     * there does not exists a path between the given vertices.
     */
    public LinkedList<E> getShortestPath(E key1, E key2) {
        // Return the path to key 2 of the MST from key 1
        return getMinimumSpanningTree(key1, key2, rand()).getPath(key2);
    }

    /**
     * This method returns the count of unconnected paris.
     * @return number of unconnected pairs.
     */
    public int countUnconnectedPairs() {
        // See if we can use a cached result
        if (_unconnectedPairs > -1) {
            return _unconnectedPairs;
        }

        // Generate a new visit ID and setup vars
        UUID visitID = rand();
        int unconnectedCount = 0;
        int totalVertexCount = 0;
        LinkedList<Integer> compSizes = new LinkedList<>();

        // Get all the component sizes
        for (Vertex<E> vertex : _vertices.values()) {
            if (vertex.visitID != visitID) {
                // This element is not part of any existing MST
                MST<E> mst = getMinimumSpanningTree(vertex.key, null, visitID);
                compSizes.append(mst.size);
                totalVertexCount += mst.size;
                if (totalVertexCount >= _vertices.size()) {
                    // Done
                    break;
                }
            }
        }

        // Do math on the component sizes
        // total = a + b(a) + c(a + b) + d(a + b + c) + ...
        if (compSizes.size > 1) {
            int count = 0;
            int mult = 0;
            LinkedListIterator<Integer> cIt = compSizes.iterator();
            while (cIt.hasNext()) {
                int c = cIt.next();
                unconnectedCount += (c * mult);
                mult += c;
                count++;
            }
        }

        // Set the value cache and return
        _unconnectedPairs = unconnectedCount;
        return _unconnectedPairs;
    }

    /**
     * This method returns a LinkedList of most connceted nodes.
     * @return LinkedList of most connected nodes
     */
    public LinkedList<E> getMostConnectedNodes() {
        // See if we can use a cached result
        if (_mostConnectedNodes != null) {
            return _mostConnectedNodes;
        }

        // Determine the connectivities
        double maxConnectivity = -1;
        LinkedList<E> mostConnectedNodes = new LinkedList<>();
        
        // Iterate over the nodes
        for (Vertex<E> vertex : _vertices.values()) {
            // Get eh connectivity for this node
            double thisConnectivity = getConnectivityRating(vertex);
            if (thisConnectivity >= maxConnectivity) {
                // This is a winner circle node
                if (thisConnectivity > maxConnectivity) {
                    // This beats out existing nodes. Clear list.
                    mostConnectedNodes = new LinkedList<>();
                    maxConnectivity = thisConnectivity;
                }
                
                // Add it to the list
                mostConnectedNodes.append(vertex.key);
            }
        }

        // Set the value cache and return
        _mostConnectedNodes = mostConnectedNodes;
        return _mostConnectedNodes;
    }

    // Private methods
    /** This is a private method. */
    // Sets the readonly flag ot true.
    private void setReadonlyMode() {
        _readOnly = true;
    }

    /**
     * This is a private method.
     * @throws Exception if the result is invalid.
     */
     // Checks the readonly flag. If true, throws an exception
     // Called by modification methods
    private void checkReadOnlyMode() throws Exception {
        if (_readOnly) {
            throw new Exception("Cannot modify the friends graph now");
        }
    }

    /** 
     * Returns a the BFS minimum spanning tree of the graph starting at startKey
     * @param startKey the starting key
     * @param stopAt the stopping key
     * @param visitID the visit ID
     * @return MST
     */
    private MST<E> getMinimumSpanningTree(E startKey, E stopAt, UUID visitID) {
        // Setup our lists
        LinkedList<Vertex<E>> fromList = new LinkedList<>();
        LinkedList<Vertex<E>> toList = new LinkedList<>();
        LinkedList<Vertex<E>> startingPts = new LinkedList<>();

        // Visit first node
        Vertex<E> start = _vertices.get(startKey);
        fromList.append(null);
        toList.append(start);
        start.visitID = visitID;
        startingPts.append(start);

        // Visit other nodes using BFS
        boolean stop = false;
        while (startingPts.size > 0) {
            // This will be our new starting points next iteration
            LinkedList<Vertex<E>> newStartingPts = new LinkedList<>();
            // Get the iterator
            LinkedListIterator<Vertex<E>> startingPtIt = startingPts.iterator();
            // Iterate over each current starting point
            while (startingPtIt.hasNext()) {
                // get this starting point
                Vertex<E> startingPt = startingPtIt.next();
                // get its neighbors
                LinkedList<Vertex<E>> neighbors = startingPt.neighbors;
                // Get the iterator
                LinkedListIterator<Vertex<E>> neighborIt = neighbors.iterator();
                // Iterate over each neighbor
                while (neighborIt.hasNext()) {
                    // Get the neighbor
                    Vertex<E> neighbor = neighborIt.next();
                    if (neighbor.visitID != visitID) {
                        // Uncharted territory. Claim it
                        fromList.append(startingPt);
                        toList.append(neighbor);
                        newStartingPts.append(neighbor);
                        neighbor.visitID = visitID;

                        // Stop early?
                        if (stopAt == neighbor.key) {
                            stop = true;
                            break;
                        }
                    }
                    if (stop) {
                        break;
                    }
                }
                if (stop) {
                    break;
                }
            }
            if (stop) {
                break;
            }
            
            // Set the new starting points for BFS
            startingPts = newStartingPts;
        }

        // Return the minimum spanning tree
        return new MST<>(fromList, toList);
    }

    /**
     * gets the connectivity of the specific vertex
     * @param vertex of a graph
     * @return number of connectivity rating
     */
    private double getConnectivityRating(Vertex<E> vertex) {
        // get the MST for this node
        MST<E> mst = getMinimumSpanningTree(vertex.key, null, rand());
        // Determine the connectivity of the MST
        return mst.getConnectivityRating();
    }

    /**
     * Generates a randome visit ID
     * rand method.
     * @return UUID
     */
    private UUID rand() {
        return UUID.randomUUID();
    }
}