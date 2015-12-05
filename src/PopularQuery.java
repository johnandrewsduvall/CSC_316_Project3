
public class PopularQuery extends Query<PopularQueryResult> {
     /**
     *
     * @param mgr
     * @return
     */
    @Override
    public PopularQueryResult execute(FriendshipManager mgr){
        return new PopularQueryResult(mgr.getPopularKids());
    }
}
