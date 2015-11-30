import java.util.*;

public class Graph<E> {
    // Map of node value -> index
    private TreeMap<E, Integer> _nodeIndices = new TreeMap<E, Integer>();

    // Map of index -> node value
    private TreeMap<Integer, E> _indexNodes = new TreeMap<Integer, E>();

    // Adjacency matrix
    private boolean[][] _matrix = null;

    public Graph(ArrayList<E> allNodeValues) {
        int count = 0;
        for (E nodeValue : allNodeValues) {
            int c = count++;
            _nodeIndices.put(nodeValue, c);
            _indexNodes.put(c, nodeValue);
        }
        _matrix = new boolean[count][count];
    }

    public void link(E val1, E val2) {
        int idx1 = _nodeIndices.get(val1);
        int idx2 = _nodeIndices.get(val2);
        _matrix[idx1][idx2] = _matrix[idx2][idx1] = true;
    }

    public boolean areDirectlyLinked(E val1, E val2) {
        int idx1 = _nodeIndices.get(val1);
        int idx2 = _nodeIndices.get(val2);
        return _matrix[idx1][idx2];
    }

    public ArrayList<E> getMutual(E val1, E val2) {
        int idx1 = _nodeIndices.get(val1);
        int idx2 = _nodeIndices.get(val2);
        ArrayList<E> mutual = new ArrayList<E>();
        for (int i = 0; i < _matrix.length; i++) {
          if (_matrix[idx1][i] && _matrix[idx2][i]) {
            mutual.add(_indexNodes.get(i));
          }
        }
        return mutual;
    }

    public ArrayList<E> getShortestPath(E from, E to) {
        // Setup
        TreeMap<Integer, Edge> mst = new TreeMap<Integer, Edge>();
        int len = 0;
        ArrayList<Integer> nodeIndicesDiscovered = new ArrayList<Integer>();

        // "Discover" first node
        int startIdx = _nodeIndices.get(from);
        nodeIndicesDiscovered.add(startIdx);
        mst.put(startIdx, new Edge(len, startIdx, startIdx));

        // Continue discovery of the MST via BFS
        while (!nodeIndicesDiscovered.isEmpty()) {
            len++;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int fromIdx : nodeIndicesDiscovered) {
                ArrayList<Integer> neighborIndices = getNeighborIndices(fromIdx);
                for (int toIdx : neighborIndices) {
                    if (!mst.containsKey(toIdx)) {
                        // This is a new node. "Discover" it
                        mst.put(toIdx, new Edge(len, toIdx, fromIdx));
                        temp.add(toIdx);
                    }
                }
            }
            nodeIndicesDiscovered = temp;
        }

        // We have finished discovery
        ArrayList<E> result = new ArrayList<E>();
        result.add(to);
        int toIdx = _nodeIndices.get(to);
        while (toIdx != startIdx) {
            Edge edge = mst.get(toIdx);
            result.add(_indexNodes.get(edge.fromIdx));
            toIdx = edge.fromIdx;
        }
        Collections.reverse(result);

        return result;
    }

    public int countUnconnectedPairs() {
        // TODO: Write this
        // (multiply all connecte component counts [unless there are 1])/
        return -1;
    }

    // private methods
    private ArrayList<Integer> getNeighborIndices(int idx) {
        ArrayList<Integer> neighborIndices = new ArrayList<Integer>();
        for (int i = 0; i < _matrix[idx].length; i++) {
            if (_matrix[idx][i]) {
                neighborIndices.add(i);
            }
        }
        return neighborIndices;
    }
}