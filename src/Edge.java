public class Edge {
    public int culumativeLength;
    public int toIdx;
    public int fromIdx;

    public Edge(int culumativeLength, int toIdx, int fromIdx) {
        this.culumativeLength = culumativeLength;
        this.toIdx = toIdx;
        this.fromIdx = fromIdx;
    }
}