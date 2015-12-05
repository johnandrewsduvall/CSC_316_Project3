
public class PopularQuery extends Query<PopularQueryResult> {
    
    PopularQuery() {
    }
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
