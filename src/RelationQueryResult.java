/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The query result for the relation command, stored a LinkedList of Strings
 */

public class RelationQueryResult extends QueryResult {
    public LinkedList<String> relationPath;

    /**
     *
     * @param relationPath
     */
    public RelationQueryResult(LinkedList<String> relationPath) {
        this.relationPath = relationPath;
    }

    @Override
    public String print() {
        return printList(this.relationPath);
    }
}
