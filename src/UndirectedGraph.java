import java.util.*;

public class UndirectedGraph<E> {
    private boolean _readOnly = false;
    private LinkedHashMap<E, Vertex<E>> _vertices = new LinkedHashMap<E, Vertex<E>>();

    // Graph modification methods
    public void addVertex(E key) throws Exception {
        checkReadOnlyMode();
        _vertices.put(key, new Vertex<E>(key));
    }

    public void addEdge(E key1, E key2) throws Exception {
        checkReadOnlyMode();
        Vertex<E> v1 = _vertices.get(key1);
        Vertex<E> v2 = _vertices.get(key2);
        v1.neighbors.append(v2);
        v2.neighbors.append(v1);
    }

    // Graph query methods
    public boolean areNeighbors(E key1, E key2) {
        // Get the 1st vertex
        Vertex<E> v1 = _vertices.get(key1);
        if (v1.neighbors.size == 0) {
            return false;
        }

        // Get the 2nd vertex
        Vertex<E> v2 = _vertices.get(key2);
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

    public LinkedList<E> getMutualNeighbors(E key1, E key2) {
        LinkedList<E> mutual = new LinkedList<E>();

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

        LinkedListIterator<Vertex<E>> n1It = n1.iterator();
        while (n1It.hasNext()) {
            Vertex<E> c1 = n1It.next();
            LinkedListIterator<Vertex<E>> n2It = n2.iterator();
            while (n2It.hasNext()) {
                Vertex<E> c2 = n2It.next();
                if (c1 == c2) {
                    mutual.append(c1.key);
                    break;
                }
            }
        }

        return mutual;
    }

    public LinkedList<E> getShortestPath(E key1, E key2) {
        return getMinimumSpanningTree(key1, key2, rand()).getPath(key2);
    }

    public int countUnconnectedPairs() {
        UUID visitID = rand();
        int unconnectedCount = 0;
        int totalVertexCount = 0;
        LinkedList<Integer> compSizes = new LinkedList<Integer>();

        // Get all the component sizes
        for (Vertex<E> vertex : _vertices.values()) {
            if (vertex.visitID != visitID) {
                // This element is not part of any existing MST
                MST<E> mst = getMinimumSpanningTree(vertex.key, null, visitID);
                compSizes.append(mst.size);
                totalVertexCount += mst.size;
                if (totalVertexCount >= _vertices.size()) {
                    break;
                }
            }
        }

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

        return unconnectedCount;
    }

    public LinkedList<E> getMostConnectedNodes() {
        double maxConnectivity = -1;
        LinkedList<E> mostConnectedNodes = new LinkedList<E>();
        for (Vertex<E> vertex : _vertices.values()) {
            double thisConnectivity = getConnectivityRating(vertex);
            if (thisConnectivity >= maxConnectivity) {
                if (thisConnectivity > maxConnectivity) {
                    mostConnectedNodes = new LinkedList<E>();
                    maxConnectivity = thisConnectivity;
                }
                mostConnectedNodes.append(vertex.key);
            }
        }
        return mostConnectedNodes;
    }

    // Private methods
    private void setReadonlyMode() {
        _readOnly = true;
    }

    private void checkReadOnlyMode() throws Exception {
        if (_readOnly) {
            throw new Exception("Cannot modify the friends graph now");
        }
    }

    private MST<E> getMinimumSpanningTree(E startKey, E stopAt, UUID visitID) {
        LinkedList<Vertex<E>> fromList = new LinkedList<Vertex<E>>();
        LinkedList<Vertex<E>> toList = new LinkedList<Vertex<E>>();
        LinkedList<Vertex<E>> startingPts = new LinkedList<Vertex<E>>();

        // System.out.println("Building a MST using BFS starting from " + startKey.toString());

        // Visit first node
        Vertex<E> start = _vertices.get(startKey);
        fromList.append(null);
        toList.append(start);
        start.visitID = visitID;
        startingPts.append(start);

        // Visit other nodes using BFS
        boolean stop = false;
        while (startingPts.size > 0) {
            LinkedList<Vertex<E>> newStartingPts = new LinkedList<Vertex<E>>();
            LinkedListIterator<Vertex<E>> startingPtIt = startingPts.iterator();
            while (startingPtIt.hasNext()) {
                Vertex<E> startingPt = startingPtIt.next();
                LinkedList<Vertex<E>> neighbors = startingPt.neighbors;
                LinkedListIterator<Vertex<E>> neighborIt = neighbors.iterator();
                while (neighborIt.hasNext()) {
                    Vertex<E> neighbor = neighborIt.next();
                    if (neighbor.visitID != visitID) {
                        // Uncharted territory. Claim it
                        // System.out.println("Claiming " + neighbor.key.toString() + " from " + startingPt.key.toString());
                        fromList.append(startingPt);
                        toList.append(neighbor);
                        newStartingPts.append(neighbor);
                        neighbor.visitID = visitID;

                        // Stop early?
                        if (stopAt == neighbor.key) {
                            stop = true;
                            break;
                        }
                    } else {
                        // System.out.println("Looked at " + neighbor.key.toString() + " from " + startingPt.key.toString() + " but it has already been visited");
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
            startingPts = newStartingPts;
        }

        // Return the minimum spanning tree
        return new MST<E>(fromList, toList);
    }

    private double getConnectivityRating(Vertex<E> vertex) {
        MST<E> mst = getMinimumSpanningTree(vertex.key, null, rand());
        return mst.getConnectivityRating();
    }

    private UUID rand() {
        return UUID.randomUUID();
    }
}