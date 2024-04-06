package LLD.Fundamentals.ObserverDesign;

public class Client {

    public static void main(String[] args) {
        Group group = new Group();

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        group.subscribe(user1);
        group.subscribe(user2);
        group.subscribe(user3);

        group.notifyAll("Initial Message");

        System.out.println("Unsubscribe user 1");

        group.unsubscribe(user1);

        group.notifyAll("new message");
    }

}
