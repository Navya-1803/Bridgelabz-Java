package DesignPattern.creational;

public class SingletonPattern {

    static class Logger {

        private static Logger instance;

        private Logger() {
            System.out.println("Logger instance created");
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in");

        System.out.println("Are both instances same? "
                + (logger1 == logger2));
    }
}