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
    }

    private static void assertEqual(Object expected, Object actual) throws Exception {
        if (expected != actual) {
            throw new Exception("Expected " + expected + " but got " + actual);
        }
    }
}