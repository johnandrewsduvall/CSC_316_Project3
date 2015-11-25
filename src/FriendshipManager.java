import java.util.*;

public class FriendshipManager {
    private int _lonerCount = 0;
    private Graph<String> _network = new Graph<String>();

    public void addLoner(String name) {
        _lonerCount++;
    }

    public void makeFriend(String name1, String name2) {
        Node<String> person1 = getPerson(name1, true);
        Node<String> person2 = getPerson(name2, true);
        person1.neighbors.add(person2);
        person2.neighbors.add(person1);
    }

    public boolean areFriends(String name1, String name2) {
        Node<String> person1 = getPerson(name1, false);
        for (Node<String> friend : person1.neighbors) {
            if (friend.value == name2) {
                return true;
            }
        }
        return false;
    }

    public boolean haveMutualFriend(String name1, String name2) {
        if (!_network.contains(name1)) {
            return false;
        }
        if (!_network.contains(name2)) {
            return false;
        }

        Node<String> popularPerson = getPerson(name1, false);
        Node<String> shyPerson = getPerson(name2, false);
        if (shyPerson.neighbors.size() > popularPerson.neighbors.size()) {
            Node<String> temp = shyPerson;
            shyPerson = popularPerson;
            popularPerson = temp;
        }

        for (Node<String> shyFriend : shyPerson.neighbors) {
            for (Node<String> popFriend : popularPerson.neighbors) {
                if (shyFriend.value == popFriend.value) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> getRelation(String name1, String name2) {
        // TODO: Write this
        return null;
    }

    public int getLonerCount() {
        return _lonerCount;
    }

    public ArrayList<String> getPopularKids() {
        // TODO: Write this
        return null;
    }

    // Private methods
    private Node<String> getPerson(String name, boolean autoAllocateLoners) {
        if (_network.contains(name)) {
            return _network.get(name);
        }

        if (autoAllocateLoners) {
            // Allocate the loner to the network
            _lonerCount--;
            return _network.add(name);
        }

        return null;
    }
}