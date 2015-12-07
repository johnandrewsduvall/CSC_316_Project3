/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The QueryResult object for the "mutual" command contains a list of Strings of
 * mutual friends of the given two people or and empty list if there exists no
 * mutual friends
 */
public class MutualQueryResult extends QueryResult {
    /** mutaualFriends method */
    public LinkedList<String> mutualFriends;

    /**
     * Construcor methd
     * @param mutualFriends mutal friends
     */
    public MutualQueryResult(LinkedList<String> mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    /**
     * Override method
     * @return outprint the resutl.
     */
    @Override
    public String print() {
        return printList(mutualFriends);
    }
}
