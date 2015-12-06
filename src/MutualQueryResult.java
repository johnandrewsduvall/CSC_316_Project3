/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 */

public class MutualQueryResult extends QueryResult {
    public LinkedList<String> mutualFriends;

    public MutualQueryResult(LinkedList<String> mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    @Override
    public String print() {
        return printList(mutualFriends);
    }
}
