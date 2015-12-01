public class NotConnectedQuery extends Query<NotConnectedQueryResult> {
    public NotConnectedQueryResult execute(FriendshipManager mgr){
        return new NotConnectedQueryResult(mgr.countUnconnectedPairs());
    }
}