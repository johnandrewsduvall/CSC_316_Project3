/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The Query object for the "relation" command 
 */
public class RelationQuery extends Query<RelationQueryResult> {
    /** Name of one person */
    public String name1;
    /** Name of another person */
    public String name2;

    /**
     * Constructor method.
     * @param name1 one person's name
     * @param name2 another person's name
     */
    public RelationQuery(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     * Override method
     * @param mgr Active Friendship manager containing the graph to be queried
     * @return RelationQuery result
     */
    @Override
    public RelationQueryResult execute(FriendshipManager mgr) {
        return new RelationQueryResult(mgr.getRelation(this.name1, this.name2));
    }
}
