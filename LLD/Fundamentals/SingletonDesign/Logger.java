package LLD.Fundamentals.SingletonDesign;

public class Logger {

    private static int counter = 0;

    /*
     * early Initialization
     * private static Logger logger = new Logger();
     */

    /* Lazy Initialization */
    private static Logger logger;

    public Logger() {
        counter++;
        System.out.println("New Instance of Logger Created. No. of instances: " + counter);
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println("Message is: " + message);
    }

}
