import java.util.*;
import java.io.*;
/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       December 6, 2015
 * Project:    CSC_316_Project3
 *
 * This program reads a list of friends and friendships and creates an
 * undirected graph.   This program then takes commands from standard in and
 * provides information on the friendships provided.
 */

public class SocialNetwork {
    /**
     * @param args the command line arguments
     * args[0] should contain the file path to the input file
     */
    public static void main(String[] args) {
        // Read the file to make friends

        FriendshipManager mgr = null;
        try {
            mgr = FriendshipParser.parse(readFile(args[0]));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        System.out.println("$");

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

    /**
     * @param filePath The file path to the friends & friendship file
     * @return And ArrayList of Strings of each line of the file.
     * @throws FileNotFoundException If the program does not find
     * the file provided
     */
    private static LinkedList<String> readFile(String filePath)
                                                  throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        LinkedList<String> lines = new LinkedList<>();
        while (scanner.hasNextLine()) {
            lines.append(scanner.nextLine());
        }
        return lines;
    }
}
