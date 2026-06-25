package week_1.factoryMethodPattern;
public class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Optional: Add initialization code here
    }

    // Public static method to get the single instance
    public static Logger getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A simple log method to demonstrate functionality
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}