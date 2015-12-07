/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The query object for the isFriend Command
 */
public class IsFriendQuery extends Query<IsFriendQueryResult> {
    /** A string of name of one person. */
    public String name1;
    /** A string of name of another person. */
    public String name2;

    /**
     * Constructor method.
     * @param name1 name of one person
     * @param name2 name of another person
     */
    public IsFriendQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     * Override method.
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return new IsFriendQueryResult.
     */
    @Override
    public IsFriendQueryResult execute(FriendshipManager mgr){
        return new IsFriendQueryResult(mgr.areFriends(this.name1, this.name2));
    }
}
