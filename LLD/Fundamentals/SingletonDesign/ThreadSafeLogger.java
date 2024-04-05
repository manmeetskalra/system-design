package LLD.Fundamentals.SingletonDesign;

public class ThreadSafeLogger {

    private static int counter = 0;

    private static ThreadSafeLogger loggerInstance;

    public ThreadSafeLogger() {
        counter++;
        System.out.println("No of Instance: " + counter);
    }

    public void log(String msg) {
        System.out.println(msg);
    }

    /*
     * public static synchronized ThreadSafeLogger getLogger() {
     * if (loggerInstance == null) {
     * loggerInstance = new ThreadSafeLogger();
     * }
     * return loggerInstance;
     * }
     */

    /*
     * The preceding implementation works fine and provides thread-safety, but it
     * reduces the performance because of the cost associated with the synchronized
     * method, although we need it only for the first few threads that might create
     * separate instances. To avoid this extra overhead every time, double-checked
     * locking principle is used. In this approach, the synchronized block is used
     * inside the if condition with an additional check to ensure that only one
     * instance of a singleton class is created. The following code snippet provides
     * the double-checked locking implementation:
     */

    public static ThreadSafeLogger getLogger() {
        synchronized (ThreadSafeLogger.class) {
            if (loggerInstance == null) {
                loggerInstance = new ThreadSafeLogger();
            }
        }
        return loggerInstance;
    }

}
