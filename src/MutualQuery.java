/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The Query object for the "mutual" command
 */
public class MutualQuery extends Query<MutualQueryResult> {
    /** A string of one person's name */
    public String name1;
    /** A string of another person's name */
    public String name2;

    /**
     * Constructor method.
     * @param name1 name of one person
     * @param name2 name of another person
     */
    public MutualQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     * Override method
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return MutualQueryResult
     */
    @Override
    public MutualQueryResult execute(FriendshipManager mgr) {
        return new MutualQueryResult(mgr.getMutual(this.name1, this.name2));
    }
}
