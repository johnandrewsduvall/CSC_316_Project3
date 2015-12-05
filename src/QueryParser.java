public class QueryParser {

    /**
     *
     * @param input
     * @return
     */
    public static Query parse(String input) throws Exception {
        Query query = null;
        String[] parts = input.split(" ");
        switch (parts[0])
        {
            case "isfriend":
                return new IsFriendQuery(parts[1], parts[2]);
            case "mutual":
                return new MutualQuery(parts[1], parts[2]);
            case "relation":
                return new RelationQuery(parts[1], parts[2]);
            case "notconnected":
                return new NotConnectedQuery();
            case "popular":
                return new PopularQuery();
            default:
                throw new Exception("Cannot parse " + input);
        }
    }
}