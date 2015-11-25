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

        log("Making sure Billy and Prabhu have a mutual friend");
        assertEqual(true, mgr.haveMutualFriend("Billy", "Prabhu"));
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