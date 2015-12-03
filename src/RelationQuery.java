public class RelationQuery extends Query<RelationQueryResult> {
    public String name1;
    public String name2;

    public RelationQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public RelationQueryResult execute(FriendshipManager mgr) {
        return new RelationQueryResult(mgr.getRelation(this.name1, this.name2));
    }
}
