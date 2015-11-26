import java.util.*;

public class Graph<E> {
    private TreeMap<E, Integer> _nodeIndices = new TreeMap<E, Integer>();
    private TreeMap<Integer, E> _indexNodes = new TreeMap<Integer, E>();
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

    public ArrayList<E> getShortestPath(E val1, E val2) {
        // TODO: Write this
        // (dijkstra's algorithm?)
        return null;
    }

    public int countUnconnectedPairs() {
        // TODO: Write this
        // (multiply all connecte component counts [unless there are 1])/
        return -1;
    }
}