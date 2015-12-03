import java.util.*;
import java.io.*;
/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       December 6, 2015
 * Project:    CSC_316_Project3
 */

public class SocialNetwork {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
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

    private static ArrayList<String> readFile(String filePath)
                                                  throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<String> lines = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }
}
