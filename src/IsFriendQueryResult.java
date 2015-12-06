/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * The QueryResult object for the isFriend command, contains a boolean
 */
public class IsFriendQueryResult extends QueryResult {
    public boolean isFriend;

    /**
     *
     * @param isFriend
     */
    public IsFriendQueryResult(boolean isFriend) {
        this.isFriend = isFriend;
    }


    /**
     * @return yes/no String based on the boolean content of the 
     * IsFriendQueryResult
     */
    @Override
    public String print(){
        return isFriend ? "yes" : "no";
    }
}
