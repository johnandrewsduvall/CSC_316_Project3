/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * 
 * This class is the primary manager fir the friendship graph
 */

import java.util.*;

public class FriendshipManager {
    private ArrayList<String> _friendNames = new ArrayList<>();
    private Graph<String> _graph = null;
    private boolean _readOnly = false;

    // Modify methods
    public void registerPerson(String name) throws Exception {
        checkReadOnlyMode();
        _friendNames.add(name);
    }

    public void makeFriends(String name1, String name2) throws Exception {
        checkReadOnlyMode();
        if (_graph == null) {
            _graph = new Graph<>(_friendNames);
            _friendNames = null; // free memory
        }
        _graph.link(name1, name2);
    }

    // Query methods
    public boolean areFriends(String name1, String name2) {
        setReadonlyMode();
        return _graph.areDirectlyLinked(name1, name2);
    }

    public ArrayList<String> getMutual(String name1, String name2) {
        setReadonlyMode();
        return _graph.getMutual(name1, name2);
    }

    public ArrayList<String> getRelation(String name1, String name2) {
        setReadonlyMode();
        return _graph.getShortestPath(name1, name2);
    }

    public int countUnconnectedPairs() {
        setReadonlyMode();
        return _graph.countUnconnectedPairs();
    }

    public ArrayList<String> getPopularKids() {
        setReadonlyMode();
        return _graph.getMostConnectedNodes();
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
}
