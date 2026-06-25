package week_1.singleton_pattern;

import week_1.factoryMethodPattern.Logger;

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Attempt to get multiple instances of the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger
        logger1.log("Application started.");
        logger2.log("Processing data...");

        // Verify that both references point to the exact same object in memory
        if (logger1 == logger2) {
            System.out.println("Success: Both logger variables point to the same instance!");
        } else {
            System.out.println("Failure: Different instances were created.");
        }
    }
}