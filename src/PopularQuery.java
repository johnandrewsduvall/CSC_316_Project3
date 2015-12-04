
public class PopularQuery extends Query<PopularQueryResult> {
    String name;
    
    PopularQuery(String name) {
        this.name = name;
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
