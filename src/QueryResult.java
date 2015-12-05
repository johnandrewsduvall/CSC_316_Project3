import java.util.*;

/**
 * @author John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * This interface defines results given from query commands.
 */
public abstract class QueryResult {
    public abstract String print();

    /**
     *
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
