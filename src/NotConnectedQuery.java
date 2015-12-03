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
