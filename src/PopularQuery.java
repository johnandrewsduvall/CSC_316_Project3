/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 */
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
