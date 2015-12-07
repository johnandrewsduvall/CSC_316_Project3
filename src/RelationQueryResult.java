/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The query result for the relation command, stored a LinkedList of Strings
 */
public class RelationQueryResult extends QueryResult {
    /** relationPath method */
    public LinkedList<String> relationPath;

    /**
     * Constructor method
     * @param relationPath LinkedList of relation path
     */
    public RelationQueryResult(LinkedList<String> relationPath) {
        this.relationPath = relationPath;
    }

    /**
     * Override method.
     * @return the formmated result
     */
    @Override
    public String print() {
        return printList(this.relationPath);
    }
}
