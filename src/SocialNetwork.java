import java.util.*;
/**
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */

public class SocialNetwork {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read the file to make friends
        FriendshipManager mgr = FriendshipParser.parse(readFile(args[0]));

        // Read the std input to get queries
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("quit")) {
                return;
            }

            // Parse the query
            Query query = QueryParser.parse(line);

            // Get the result
            QueryResult result = query.execute(mgr);

            // Print the result followed by a $
            System.out.println(result.print());
            System.out.println("$");
        }
    }

    private static List<String> readFile(String filePath) {
        // TODO: Write this
        return null;
    }
}
