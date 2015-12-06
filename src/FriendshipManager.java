/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 *
 * This class is the primary manager for the friendship graph
 */


public class FriendshipManager {
    private UndirectedGraph<String> _graph = new UndirectedGraph<>();

    // Modify methods
    
    /**
     *
     * @param name
     * @throws Exception
     */
    public void registerPerson(String name) throws Exception {
        _graph.addVertex(name);
    }

    /**
     *
     * @param name1
     * @param name2
     * @throws Exception
     */
    public void makeFriends(String name1, String name2) throws Exception {
        _graph.addEdge(name1, name2);
    }

    // Query methods
    
    /**
     *
     * @param name1
     * @param name2
     * @return
     */
        
    public boolean areFriends(String name1, String name2) {
        return _graph.areNeighbors(name1, name2);
    }

    /**
     *
     * @param name1
     * @param name2
     * @return
     */
    public LinkedList<String> getMutual(String name1, String name2) {
        return _graph.getMutualNeighbors(name1, name2);
    }

    /**
     *
     * @param name1
     * @param name2
     * @return
     */
    public LinkedList<String> getRelation(String name1, String name2) {
        return _graph.getShortestPath(name1, name2);
    }

    /**
     *
     * @return
     */
    public int countUnconnectedPairs() {
        return _graph.countUnconnectedPairs();
    }

    /**
     *
     * @return
     */
    public LinkedList<String> getPopularKids() {
        return _graph.getMostConnectedNodes();
    }
}
