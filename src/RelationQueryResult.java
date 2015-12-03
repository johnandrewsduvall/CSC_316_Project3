import java.util.*;

public class RelationQueryResult extends QueryResult {
    public ArrayList<String> relationPath;

    public RelationQueryResult(ArrayList<String> relationPath) {
        this.relationPath = relationPath;
    }

    @Override
    public String print() {
        return printArrayList(this.relationPath);
    }
}
