package LLD.Fundamentals.ObserverDesign;

public class User implements ISubscriber {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public void notify(String msg) {
        System.out.println("User: " + userId + " has recieved the message: " + msg);
    }
}
