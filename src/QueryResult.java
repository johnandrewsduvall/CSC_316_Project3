/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * This abstract class defines results given from query commands.
 */
public abstract class QueryResult {
    /** Abstract method of print */
    public abstract String print();

    /**
     * printList method.
     * @param lines LinkedList of strings to be turned into output String
     * @return The formatted Output String
     */
    protected String printList(LinkedList<String> lines) {
        StringBuilder sb = new StringBuilder();
        if (lines != null) {
            LinkedListIterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(iterator.next());
            }
        }
        return sb.toString();
    }
}
