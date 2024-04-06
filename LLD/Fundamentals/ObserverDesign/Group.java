package LLD.Fundamentals.ObserverDesign;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<ISubscriber> users;

    public Group() {
        users = new ArrayList<>();
    }

    public void subscribe(ISubscriber usr) {
        users.add(usr);
    }

    public void unsubscribe(ISubscriber usr) {
        users.remove(usr);
    }

    public void notifyAll(String msg) {
        users.stream().forEach(user -> user.notify(msg));
    }
}
