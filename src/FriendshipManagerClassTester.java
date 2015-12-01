import java.util.*;

public class FriendshipManagerClassTester {
    public static void main(String[] args) throws Exception {
        try {
            test();
            System.out.println("Test passed");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
            throw e;
        }
    }

    private static void test() throws Exception {
        testFriends();
        testShortesPath();
        testUnconnectedPairs();
        testPopularity();
    }

    private static void testFriends() throws Exception {
        FriendshipManager mgr = new FriendshipManager();

        // Create people
        mgr.registerPerson("Omar");
        mgr.registerPerson("Sally");
        mgr.registerPerson("Shantal");
        mgr.registerPerson("Billy");
        mgr.registerPerson("Diego");
        mgr.registerPerson("Prabhu");
        mgr.registerPerson("Natasha");

        // Assign friendships
        mgr.makeFriends("Billy", "Shantal");
        mgr.makeFriends("Diego", "Sally");
        mgr.makeFriends("Shantal", "Prabhu");
        mgr.makeFriends("Diego", "Omar");
        mgr.makeFriends("Natasha", "Sally");
        mgr.makeFriends("Omar", "Sally");
        mgr.makeFriends("Diego", "Natasha");

        // Assert friendships
        assertEqual(true, mgr.areFriends("Billy", "Shantal"));
        assertEqual(true, mgr.areFriends("Shantal", "Billy"));
        assertEqual(true, mgr.areFriends("Shantal", "Prabhu"));
        assertEqual(true, mgr.areFriends("Prabhu", "Shantal"));

        assertEqual(true, mgr.areFriends("Diego", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Diego"));
        assertEqual(true, mgr.areFriends("Diego", "Omar"));
        assertEqual(true, mgr.areFriends("Omar", "Diego"));
        assertEqual(true, mgr.areFriends("Natasha", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Natasha"));
        assertEqual(true, mgr.areFriends("Omar", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Omar"));

        // Assert mutual relations
        log("Mutual Shantal");
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("Shantal");
        assertElementsEqual(expectedList,  mgr.getMutual("Billy", "Prabhu"));

        log("Mutual Omar & Natasha");
        expectedList.clear();
        expectedList.add("Omar");
        expectedList.add("Natasha");
        assertElementsEqual(expectedList,  mgr.getMutual("Sally", "Diego"));

        log("Mutual Diego");
        expectedList.clear();
        expectedList.add("Diego");
        assertElementsEqual(expectedList,  mgr.getMutual("Omar", "Sally"));
        assertElementsEqual(expectedList,  mgr.getMutual("Sally", "Natasha"));

        log("Mutual Sally");
        expectedList.clear();
        expectedList.add("Sally");
        assertElementsEqual(expectedList,  mgr.getMutual("Diego", "Natasha"));
        assertElementsEqual(expectedList,  mgr.getMutual("Diego", "Omar"));

        log("Mutual Sally & Diego");
        expectedList.add("Diego");
        assertElementsEqual(expectedList,  mgr.getMutual("Natasha", "Omar"));
    }

    private static void testShortesPath() throws Exception {
        log("Creating friends graph");
        FriendshipManager mgr = new FriendshipManager();
        mgr.registerPerson("A");
        mgr.registerPerson("B");
        mgr.registerPerson("C");
        mgr.registerPerson("D");
        mgr.registerPerson("E");
        mgr.registerPerson("F");
        mgr.registerPerson("G");
        mgr.registerPerson("H");
        mgr.registerPerson("I");
        mgr.registerPerson("J");

        mgr.makeFriends("A", "B");
        mgr.makeFriends("A", "C");
        mgr.makeFriends("A", "D");
        mgr.makeFriends("B", "D");
        mgr.makeFriends("B", "G");
        mgr.makeFriends("C", "D");
        mgr.makeFriends("D", "F");
        mgr.makeFriends("D", "E");
        mgr.makeFriends("F", "E");
        mgr.makeFriends("H", "E");
        mgr.makeFriends("H", "I");
        mgr.makeFriends("I", "J");
        mgr.makeFriends("C", "J");

        ArrayList<String> expected = new ArrayList<String>();

        // A -> E
        log("Testing A -> E path");
        expected.clear();
        expected.add("A");
        expected.add("D");
        expected.add("E");
        assertElementsEqual(expected, mgr.getRelation("A", "E"));

        // A -> I
        log("Testing A -> I path");
        expected.clear();
        expected.add("A");
        expected.add("C");
        expected.add("J");
        expected.add("I");
        assertElementsEqual(expected, mgr.getRelation("A", "I"));

        // D -> G
        log("Testing D -> G path");
        expected.clear();
        expected.add("D");
        expected.add("B");
        expected.add("G");
        assertElementsEqual(expected, mgr.getRelation("D", "G"));

        // D -> I
        log("Testing D -> I path");
        expected.clear();
        expected.add("D");
        expected.add("C");
        expected.add("J");
        expected.add("I");
        assertElementsEqual(expected, mgr.getRelation("D", "I"));
    }

    private static void testUnconnectedPairs() throws Exception {
        FriendshipManager mgr = new FriendshipManager();

        log("Creating a graph");
        mgr.registerPerson("A1");
        mgr.registerPerson("A2");
        mgr.registerPerson("A3");
        mgr.registerPerson("A4");
        mgr.registerPerson("B1");
        mgr.registerPerson("B2");
        mgr.registerPerson("B3");
        mgr.registerPerson("C1");
        mgr.registerPerson("C2");
        mgr.registerPerson("D1");

        log("Grouping into 4 separate components");
        mgr.makeFriends("A1", "A2");
        mgr.makeFriends("A1", "A3");
        mgr.makeFriends("A1", "A4");
        mgr.makeFriends("B1", "B2");
        mgr.makeFriends("B1", "B3");
        mgr.makeFriends("C1", "C2");

        log("Checking the expected unconnected pair count");
        assertEqual(36, mgr.countUnconnectedPairs());
    }

    private static void testPopularity() throws Exception {
        log("Creating friends graph");
        FriendshipManager mgr = new FriendshipManager();
        mgr.registerPerson("A");
        mgr.registerPerson("B");
        mgr.registerPerson("C");
        mgr.registerPerson("D");
        mgr.registerPerson("E");
        mgr.registerPerson("F");
        mgr.registerPerson("G");
        mgr.registerPerson("H");

        mgr.makeFriends("A", "B");
        mgr.makeFriends("A", "C");
        mgr.makeFriends("D", "C");

        mgr.makeFriends("E", "F");
        mgr.makeFriends("G", "F");
        mgr.makeFriends("E", "H");

        log("Checking popularity");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("A");
        expected.add("C");
        expected.add("E");
        expected.add("F");

        assertElementsEqual(expected, mgr.getPopularKids());
    }

    private static void log(String message) {
        System.out.println(message);
    }

    private static void assertElementsEqual(ArrayList<String> expectedList, ArrayList<String> actualList) throws Exception {
        assertEqual(expectedList.size(), actualList.size());
        for (String val : expectedList) {
            if (!actualList.contains(val)) {
                throw new Exception("Couldn't find " + val + " in the list " + Arrays.toString(actualList.toArray()));
            }
        }
    }

    private static void assertEqual(Object expected, Object actual) throws Exception {
        if (expected != actual) {
            throw new Exception("Expected " + expected + " but got " + actual);
        }
    }
}