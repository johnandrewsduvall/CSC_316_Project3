/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query results for the notConnected command, holds an int as it's result
 */
public class NotConnectedQueryResult extends QueryResult {
    /** number of not connected pairs */
    public int unConnectedPairs;

    /**
     * Constructor method.
     * @param unConnectedPairs number of not connected paris.
     */
    public NotConnectedQueryResult(int unConnectedPairs) {
        this.unConnectedPairs = unConnectedPairs;
    }

    /**
     * Override method.
     * @return outprint result
     */
    @Override
    public String print() {
        return Integer.toString(this.unConnectedPairs);
    }
}
