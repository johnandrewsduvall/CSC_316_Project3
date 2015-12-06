/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The Query object for the "mutual" command
 */

public class MutualQuery extends Query<MutualQueryResult> {
    public String name1;
    public String name2;

    /**
     *
     * @param name1
     * @param name2
     */
    public MutualQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     *
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return
     */
    @Override
    public MutualQueryResult execute(FriendshipManager mgr) {
        return new MutualQueryResult(mgr.getMutual(this.name1, this.name2));
    }
}
