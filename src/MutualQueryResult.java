import java.util.*;

public class MutualQueryResult extends QueryResult {
    public ArrayList<String> mutualFriends;

    public MutualQueryResult(ArrayList<String> mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    @Override
    public String print() {
        return printArrayList(mutualFriends);
    }
}
