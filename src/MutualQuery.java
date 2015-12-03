public class MutualQuery extends Query<MutualQueryResult> {
    public String name1;
    public String name2;

    public MutualQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     *
     * @param mgr
     * @return
     */
    @Override
    public MutualQueryResult execute(FriendshipManager mgr) {
        return new MutualQueryResult(mgr.getMutual(this.name1, this.name2));
    }
}
