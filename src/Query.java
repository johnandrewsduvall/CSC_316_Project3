/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * @param <E> 
 * This abstract class defines the Query Superclass
 */
public abstract class Query<E extends QueryResult>  {
    /** 
     * Abstract method of execute.
     * @param mgr Active Friendship manager containing the graph to be queried
     */
    public abstract E execute(FriendshipManager mgr);
}