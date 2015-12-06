/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * Constructs query object from a line of input
 */

public class QueryParser {

    /**
     *
     * @param input line of input to be parsed
     * @return extends query 
     * @throws java.lang.Exception if the line cannot be parsed
     */
    public static Query parse(String input) throws Exception {
        String[] parts = input.split(" ");
        switch (parts[0]){
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