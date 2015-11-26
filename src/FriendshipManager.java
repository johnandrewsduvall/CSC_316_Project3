import java.util.*;

public class FriendshipManager {
    private ArrayList<String> _friendNames = new ArrayList<String>();
    private Graph<String> _graph = null;

    public void registerFriendName(String name) {
        _friendNames.add(name);
    }

    public void makeFriends(String name1, String name2) {
        if (_graph == null) {
            _graph = new Graph<String>(_friendNames);
            _friendNames = null; // free memory
        }
        _graph.link(name1, name2);
    }

    public boolean areFriends(String name1, String name2) {
        return _graph.areDirectlyLinked(name1, name2);
    }

    public ArrayList<String> getMutual(String name1, String name2) {
        return _graph.getMutual(name1, name2);
    }

    public ArrayList<String> getRelation(String name1, String name2) {
        return _graph.getShortestPath(name1, name2);
    }

    public ArrayList<String> getPopularKids() {
        // TODO: Write this. Use the relation query?
        return null;
    }
}