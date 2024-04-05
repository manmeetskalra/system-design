package LLD.Fundamentals.SingletonDesign;

public class ThreadSafeUser {

    public void user1() {
        ThreadSafeLogger l1 = ThreadSafeLogger.getLogger();
        l1.log("User 1 logs");
    }

    public void user2() {
        ThreadSafeLogger l1 = ThreadSafeLogger.getLogger();
        l1.log("User 2 logs");
    }

    public static void main(String[] args) {
        ThreadSafeUser user = new ThreadSafeUser();
        user.user1();
        user.user2();

    }
}
