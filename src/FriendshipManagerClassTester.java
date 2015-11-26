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
        log("Registering 7 friend names");
        mgr.registerFriendName("Omar");
        mgr.registerFriendName("Sally");
        mgr.registerFriendName("Shantal");
        mgr.registerFriendName("Billy");
        mgr.registerFriendName("Diego");
        mgr.registerFriendName("Prabhu");
        mgr.registerFriendName("Natasha");

        // Assign friendships
        log("Making Billy and Shantal friends");
        mgr.makeFriends("Billy", "Shantal");
        assertEqual(true, mgr.areFriends("Billy", "Shantal"));
        assertEqual(true, mgr.areFriends("Shantal", "Billy"));

        log("Making Diego and Sally friends");
        mgr.makeFriends("Diego", "Sally");
        assertEqual(true, mgr.areFriends("Diego", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Diego"));

        log("Making Shantal and Prabhu friends");
        mgr.makeFriends("Shantal", "Prabhu");
        assertEqual(true, mgr.areFriends("Shantal", "Prabhu"));
        assertEqual(true, mgr.areFriends("Prabhu", "Shantal"));

        log("Making Diego and Omar friends");
        mgr.makeFriends("Diego", "Omar");
        assertEqual(true, mgr.areFriends("Diego", "Omar"));
        assertEqual(true, mgr.areFriends("Omar", "Diego"));

        log("Making Natasha and Sally friends");
        mgr.makeFriends("Natasha", "Sally");
        assertEqual(true, mgr.areFriends("Natasha", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Natasha"));

        log("Making Omar and Sally friends");
        mgr.makeFriends("Omar", "Sally");
        assertEqual(true, mgr.areFriends("Omar", "Sally"));
        assertEqual(true, mgr.areFriends("Sally", "Omar"));

        log("Making Diego and Natasha friends");
        mgr.makeFriends("Diego", "Natasha");
        assertEqual(true, mgr.areFriends("Diego", "Natasha"));
        assertEqual(true, mgr.areFriends("Natasha", "Diego"));
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