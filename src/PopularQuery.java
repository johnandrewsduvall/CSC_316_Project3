/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query object for the popular command
 */
public class PopularQuery extends Query<PopularQueryResult> {
    /**
     * Override method.
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return PopularQuery of "popular" people.
     */
    @Override
    public PopularQueryResult execute(FriendshipManager mgr){
        return new PopularQueryResult(mgr.getPopularKids());
    }
}
