/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * @param <E> 
 * This abstract class defines the Query Superclass
 */
public abstract class Query<E extends QueryResult>  {
    public abstract E execute(FriendshipManager mgr);
}