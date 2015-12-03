public class IsFriendQueryResult extends QueryResult {
    public boolean isFriend;

    /**
     *
     * @param isFriend
     */
    public IsFriendQueryResult(boolean isFriend) {
        this.isFriend = isFriend;
    }


    /**
     *
     * @return
     */
    @Override
    public String print(){
        return isFriend ? "yes" : "no";
    }
}
