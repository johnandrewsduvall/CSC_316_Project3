import java.util.*;

public class PopularQueryResult extends QueryResult {
    public ArrayList<String> popularKids;

    public PopularQueryResult(ArrayList<String> popularKids) {
        this.popularKids = popularKids;
    }

    public String print() {
        return printArray(popularKids);
    }
}