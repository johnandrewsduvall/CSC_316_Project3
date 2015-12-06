/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * 
 */

public class IsFriendQuery extends Query<IsFriendQueryResult> {
    public String name1;
    public String name2;

    public IsFriendQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     *
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return 
     */
    @Override
    public IsFriendQueryResult execute(FriendshipManager mgr){
        return new IsFriendQueryResult(mgr.areFriends(this.name1, this.name2));
    }
}
