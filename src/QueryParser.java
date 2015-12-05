public class QueryParser {

    /**
     *
     * @param input
     * @return
     */
    public static Query parse(String input) {
        Query query = null;
        String[] parts = input.split(" ");
        switch (parts[0])
        {
            case "isfriend":
                query = new IsFriendQuery(parts[1], parts[2]);
                break;
            case "mutual":
                query = new MutualQuery(parts[1], parts[2]);
                break;
            case "relation":
                query = new RelationQuery(parts[1], parts[2]);
                break;
            case "popular":
                query  = new PopularQuery();
                break;
            default: System.out.println("Error in Query Parsing");
        }
        return query;
    }
}