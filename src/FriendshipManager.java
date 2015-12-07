/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * This class is the primary manager for the friendship graph
 */
public class FriendshipManager {
    /**
     * This is a modify method.
     */
    private UndirectedGraph<String> _graph = new UndirectedGraph<>();
    
    /**
     * This method register a person in to the friendship relation.
     * @param name name of person to be added
     * @throws Exception If addition was not successful
     */
    public void registerPerson(String name) throws Exception {
        _graph.addVertex(name);
    }

    /**
     * This method make two person friends. Connects two people on the friendship graph with an undirected edge.
     * @param name1 name of one person
     * @param name2 name of another person
     * @throws Exception If the method is invalid.
     */
    public void makeFriends(String name1, String name2) throws Exception {
        _graph.addEdge(name1, name2);
    }

    // Query methods
    
    /**
     * This is a query method.
     * @param name1 name of one person
     * @param name2 name of another person
     * @return true if there exists a friendship edge between the two people
     */
        
    public boolean areFriends(String name1, String name2) {
        return _graph.areNeighbors(name1, name2);
    }

    /**
     * This method returns a list of mutual friends.
     * @param name1 name of one person
     * @param name2 name of another person
     * @return The list of mutual friends of name1 and name2, returns empty list
     * if no mutual friends are found
     */
    public LinkedList<String> getMutual(String name1, String name2) {
        return _graph.getMutualNeighbors(name1, name2);
    }

    /**
     * This method returns the shortest list of friends needed to connect the two people.
     * @param name1 name of one person
     * @param name2 name of another person
     * @return The shortest list of friends needed to connect the two people
     */
    public LinkedList<String> getRelation(String name1, String name2) {
        return _graph.getShortestPath(name1, name2);
    }

    /**
     * This method returns the number of unconnected pairs.
     * @return The number of unconnected pairs
     */
    public int countUnconnectedPairs() {
        return _graph.countUnconnectedPairs();
    }

    /**
     * This method returns a list of people in ascending order of popularity.
     * @return A list of people in ascending order of popularity
     */
    public LinkedList<String> getPopularKids() {
        return _graph.getMostConnectedNodes();
    }
}