/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The QueryResult object for the isFriend command, contains a boolean
 */
public class IsFriendQueryResult extends QueryResult {
    /** A boolean of isFriend. */
    public boolean isFriend;

    /**
     * Constructor method.
     * @param isFriend true if is friend, otherwise false.
     */
    public IsFriendQueryResult(boolean isFriend) {
        this.isFriend = isFriend;
    }

    /**
     * This method return a string of result, either yes or no.
     * @return yes/no String based on the boolean content of the IsFriendQueryResult.
     */
    @Override
    public String print(){
        return isFriend ? "yes" : "no";
    }
}
