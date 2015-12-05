import java.util.*;

public class RelationQueryResult extends QueryResult {
    public LinkedList<String> relationPath;

    public RelationQueryResult(LinkedList<String> relationPath) {
        this.relationPath = relationPath;
    }

    @Override
    public String print() {
        return printList(this.relationPath);
    }
}
