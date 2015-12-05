import java.util.*;

public class PopularQueryResult extends QueryResult {
    public LinkedList<String> popularKids;

    public PopularQueryResult(LinkedList<String> popularKids) {
        this.popularKids = popularKids;
    }

    /**
     *
     * @return
     */
    @Override
    public String print() {
        return printList(popularKids);
    }
}