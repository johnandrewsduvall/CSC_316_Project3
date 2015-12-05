/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 *
 * This class is the primary manager fir the friendship graph
 */

import java.util.*;

public class FriendshipManager {
    private UndirectedGraph<String> _graph = new UndirectedGraph<>();

    // Modify methods
    public void registerPerson(String name) throws Exception {
        _graph.addVertex(name);
    }

    public void makeFriends(String name1, String name2) throws Exception {
        _graph.addEdge(name1, name2);
    }

    // Query methods
    public boolean areFriends(String name1, String name2) {
        return _graph.areNeighbors(name1, name2);
    }

    public LinkedList<String> getMutual(String name1, String name2) {
        return _graph.getMutualNeighbors(name1, name2);
    }

    public LinkedList<String> getRelation(String name1, String name2) {
        return _graph.getShortestPath(name1, name2);
    }

    public int countUnconnectedPairs() {
        return _graph.countUnconnectedPairs();
    }

    public LinkedList<String> getPopularKids() {
        return _graph.getMostConnectedNodes();
    }
}
