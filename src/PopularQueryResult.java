/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query Result for the popular command, contains a LinkedList of Strings
 */

public class PopularQueryResult extends QueryResult {
    public LinkedList<String> popularKids;

    public PopularQueryResult(LinkedList<String> popularKids) {
        this.popularKids = popularKids;
    }

    /**
     * @return formatted output string for printing
     */
    @Override
    public String print() {
        return printList(popularKids);
    }
}