import java.util.*;

public class MutualQueryResult extends QueryResult {
    public ArrayList<String> mutualFriends;

    public MutualQueryResult(ArrayList<String> mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (String name : mutualFriends) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(name);
        }
        return sb.toString();
    }
}