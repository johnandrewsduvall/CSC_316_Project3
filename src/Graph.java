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

    public ArrayList<E> getShortestPath(E start, E end) {
        // Setup
        int startIdx = _nodeIndices.get(start);
        TreeMap<Integer, Edge> mst = getMstFromNodeIdx(startIdx);

        int endIdx = _nodeIndices.get(end);
        if (!mst.containsKey(endIdx)) {
            // No path
            return null;
        }

        // Get the path
        ArrayList<E> result = new ArrayList<E>();
        result.add(end);
        int toIdx = _nodeIndices.get(end);
        while (toIdx != startIdx) {
            Edge edge = mst.get(toIdx);
            result.add(_indexNodes.get(edge.fromIdx));
            toIdx = edge.fromIdx;
        }
        Collections.reverse(result);

        // Done
        return result;
    }

    public int countUnconnectedPairs() {
        int count = 0;
        ArrayList<TreeMap<Integer, Edge>> comps = getComponentsFromGraph();
        if (comps.size() > 1) {
            for (int i = 0; i < comps.size(); i++) {
                for (int j = i + 1; j < comps.size(); j++) {
                    count += (comps.get(i).size() * comps.get(j).size());
                }
            }
            count += comps.get(comps.size() - 1).size();
        }
        return count;
    }

    // private methods
    private ArrayList<TreeMap<Integer, Edge>> getComponentsFromGraph() {
        int remaining = _indexNodes.size();
        ArrayList<TreeMap<Integer, Edge>> components
                                      = new ArrayList<TreeMap<Integer, Edge>>();
        for (int idx : _indexNodes.keySet()) {
            boolean alreadyMapped = false;
            for (TreeMap<Integer, Edge> component : components) {
                if (component.containsKey(idx)) {
                    alreadyMapped = true;
                    break;
                }
            }

            if (!alreadyMapped) {
                TreeMap<Integer, Edge> mst = getMstFromNodeIdx(idx);
                components.add(mst);
                remaining -= mst.size();
                if (remaining == 0) {
                    // We must have mapped all keys now
                    break;
                }
            }
        }

        return components;
    }

    private TreeMap<Integer, Edge> getMstFromNodeIdx(int startIdx) {
        TreeMap<Integer, Edge> mst = new TreeMap<Integer, Edge>();
        int len = 0;
        ArrayList<Integer> nodeIndicesDiscovered = new ArrayList<Integer>();

        // "Discover" first node
        nodeIndicesDiscovered.add(startIdx);
        mst.put(startIdx, new Edge(len, startIdx, startIdx));

        // Continue discovery of the MST via BFS
        while (!nodeIndicesDiscovered.isEmpty()) {
            len++;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int fromIdx : nodeIndicesDiscovered) {
                for (int toIdx : getNeighborIndices(fromIdx)) {
                    if (!mst.containsKey(toIdx)) {
                        // This is a new node. "Discover" it
                        mst.put(toIdx, new Edge(len, toIdx, fromIdx));
                        temp.add(toIdx);
                    }
                }
            }
            nodeIndicesDiscovered = temp;
        }

        return mst;
    }

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