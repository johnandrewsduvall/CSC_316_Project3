public class PopularQuery extends Query<PopularQueryResult> {
    public PopularQueryResult execute(FriendshipManager mgr){
        return new PopularQueryResult(mgr.getPopularKids());
    }
}