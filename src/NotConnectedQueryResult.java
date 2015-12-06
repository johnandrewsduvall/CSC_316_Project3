/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Query results for the notConnected command, holds an int as it's result
 */
public class NotConnectedQueryResult extends QueryResult {
    public int unConnectedPairs;

    /**
     *
     * @param unConnectedPairs
     */
    public NotConnectedQueryResult(int unConnectedPairs) {
        this.unConnectedPairs = unConnectedPairs;
    }

    @Override
    public String print() {
        return Integer.toString(this.unConnectedPairs);
    }
}
