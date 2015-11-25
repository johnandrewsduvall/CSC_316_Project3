public class FriendshipManagerClassTester {
    public static void main(String[] args) {
        try {
            test();
            System.out.println("Test passed");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }
    }

    private static void test() throws Exception {
        FriendshipManager mgr = new FriendshipManager();

        // Create loners
        log("Creating 7 loners");
        assertEqual(0, mgr.getLonerCount());
        mgr.addLoner("Omar");
        assertEqual(1, mgr.getLonerCount());
        mgr.addLoner("Sally");
        assertEqual(2, mgr.getLonerCount());
        mgr.addLoner("Shantal");
        assertEqual(3, mgr.getLonerCount());
        mgr.addLoner("Billy");
        assertEqual(4, mgr.getLonerCount());
        mgr.addLoner("Diego");
        assertEqual(5, mgr.getLonerCount());
        mgr.addLoner("Prabhu");
        assertEqual(6, mgr.getLonerCount());
        mgr.addLoner("Natasha");
        assertEqual(7, mgr.getLonerCount());

        // Assign friendships
        log("Making Billy and Shantal friends");
        mgr.makeFriend("Billy", "Shantal");
        assertEqual(true, mgr.areFriends("Billy", "Shantal"));
        assertEqual(true, mgr.areFriends("Shantal", "Billy"));
        assertEqual(5, mgr.getLonerCount());

        log("Making Diego and Sally friends");
        mgr.makeFriend("Diego", "Sally");
        assertEqual(true, mgr.areFriends("Diego", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Diego"));
        assertEqual(3, mgr.getLonerCount());

        log("Making Shantal and Prabhu friends");
        mgr.makeFriend("Shantal", "Prabhu");
        assertEqual(true, mgr.areFriends("Shantal", "Prabhu"));
        assertEqual(true, mgr.areFriends("Prabhu", "Shantal"));
        assertEqual(2, mgr.getLonerCount());
        assertEqual(true, mgr.haveMutualFriend("Billy", "Prabhu"));

        log("Making Diego and Omar friends");
        mgr.makeFriend("Diego", "Omar");
        assertEqual(true, mgr.areFriends("Diego", "Omar"));
        assertEqual(true, mgr.areFriends("Omar", "Diego"));
        assertEqual(1, mgr.getLonerCount());
        assertEqual(true, mgr.haveMutualFriend("Sally", "Omar"));

        log("Making Natasha and Sally friends");
        mgr.makeFriend("Natasha", "Sally");
        assertEqual(true, mgr.areFriends("Natasha", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Natasha"));
        assertEqual(0, mgr.getLonerCount());
        assertEqual(true, mgr.haveMutualFriend("Natasha", "Diego"));

        log("Making Omar and Sally friends");
        mgr.makeFriend("Omar", "Sally");
        assertEqual(true, mgr.areFriends("Omar", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Omar"));
        assertEqual(0, mgr.getLonerCount());
        assertEqual(true, mgr.haveMutualFriend("Natasha", "Omar"));

        log("Making Diego and Natasha friends");
        mgr.makeFriend("Diego", "Natasha");
        assertEqual(true, mgr.areFriends("Diego", "Natasha"));
        assertEqual(true, mgr.areFriends("Natasha", "Diego"));
        assertEqual(0, mgr.getLonerCount());
    }

    private static void log(String message) {
        System.out.println(message);
    }

    private static void assertEqual(Object expected, Object actual) throws Exception {
        if (expected != actual) {
            throw new Exception("Expected " + expected + " but got " + actual);
        }
    }
}