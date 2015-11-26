import java.util.*;

public class FriendshipParser {
    public static FriendshipManager parse(ArrayList<String> lines) {
        FriendshipManager mgr = new FriendshipManager();
        boolean inFilePart1 = true;
        for (String line : lines) {
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