/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 */
public class NotConnectedQuery extends Query<NotConnectedQueryResult> {

    /**
     *
     * @param mgr
     * @return
     */
    @Override
    public NotConnectedQueryResult execute(FriendshipManager mgr){
        return new NotConnectedQueryResult(mgr.countUnconnectedPairs());
    }
}
