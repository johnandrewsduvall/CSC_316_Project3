import java.util.*;

public class PopularQueryResult extends QueryResult {
    public ArrayList<String> popularKids;

    public PopularQueryResult(ArrayList<String> popularKids) {
        this.popularKids = popularKids;
    }

    /**
     *
     * @return
     */
    @Override
    public String print() {
        return printArrayList(popularKids);
    }
}