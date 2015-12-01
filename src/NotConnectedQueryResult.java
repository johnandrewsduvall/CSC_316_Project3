public class NotConnectedQueryResult extends QueryResult {
    public int unConnectedPairs;

    public NotConnectedQueryResult(int unConnectedPairs) {
        this.unConnectedPairs = unConnectedPairs;
    }

    public String print() {
        return Integer.toString(this.unConnectedPairs);
    }
}