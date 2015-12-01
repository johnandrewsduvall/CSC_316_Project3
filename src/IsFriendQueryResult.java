public class IsFriendQueryResult extends QueryResult {
    public boolean isFriend;

    public IsFriendQueryResult(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public String print(){
        return isFriend ? "yes" : "no";
    }
}