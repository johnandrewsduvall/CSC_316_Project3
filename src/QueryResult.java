import java.util.*;

public abstract class QueryResult {
    public abstract String print();

    protected String printArrayList(ArrayList<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(line);
        }
        return sb.toString();
    }
}