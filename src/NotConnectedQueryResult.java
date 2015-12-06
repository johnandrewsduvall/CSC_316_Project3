/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 */
public class NotConnectedQueryResult extends QueryResult {
    public int unConnectedPairs;

    public NotConnectedQueryResult(int unConnectedPairs) {
        this.unConnectedPairs = unConnectedPairs;
    }

    @Override
    public String print() {
        return Integer.toString(this.unConnectedPairs);
    }
}
