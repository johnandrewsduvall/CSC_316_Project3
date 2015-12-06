/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * 
 */

public class FriendshipParser {
    public static FriendshipManager parse(LinkedList<String> lines)
                                                              throws Exception {
        FriendshipManager mgr = new FriendshipManager();
        boolean inFilePart1 = true;
        LinkedListIterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (inFilePart1) {
                if (line.equals("$")) {
                    // From now on, we're parsing friendships
                    inFilePart1 = false;
                } else {
                    // Regsiter this name
                    mgr.registerPerson(line);
                }
            } else {
                // Create this friendship
                String[] parts = line.split(" ");
                mgr.makeFriends(parts[0], parts[1]);
            }
        }
        return mgr;
    }
}