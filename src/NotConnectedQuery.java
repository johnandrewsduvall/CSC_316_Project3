/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query Object for the NotConnected command
 */
public class NotConnectedQuery extends Query<NotConnectedQueryResult> {

    /**
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return
     */
    @Override
    public NotConnectedQueryResult execute(FriendshipManager mgr){
        return new NotConnectedQueryResult(mgr.countUnconnectedPairs());
    }
}
