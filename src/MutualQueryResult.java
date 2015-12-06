/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The QueryResult object for the "mutual" command contains a list of Strings of
 * mutual friends of the given two people or and empty list if there exists no
 * mutual friends
 */

public class MutualQueryResult extends QueryResult {
    public LinkedList<String> mutualFriends;

    /**
     *
     * @param mutualFriends
     */
    public MutualQueryResult(LinkedList<String> mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    /**
     *
     * @return
     */
    @Override
    public String print() {
        return printList(mutualFriends);
    }
}
