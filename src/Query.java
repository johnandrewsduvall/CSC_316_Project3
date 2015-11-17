public abstract class Query<E extends QueryResult>  {
    public abstract E execute(FriendshipManager mgr);
}