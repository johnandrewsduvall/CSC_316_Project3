/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query Result for the popular command, contains a LinkedList of Strings
 */
public class PopularQueryResult extends QueryResult {
    /** A LinkedList of popular people */
    public LinkedList<String> popularKids;

    /**
     * Constructor method.
     * @param popularKids a LinkedList of popular perole
     */
    public PopularQueryResult(LinkedList<String> popularKids) {
        this.popularKids = popularKids;
    }

    /**
     * Override method.
     * @return formatted output string for printing
     */
    @Override
    public String print() {
        return printList(popularKids);
    }
}