public class CalulatorWithLogger {
    private final Logger logger;
    CalulatorWithLogger(Logger logger) {
        this.logger = logger;
    }

    public int add(int a, int b) {
        logger.log("Adding " + a + " + " + b);
        int result = a + b;
        logger.log("The result is " + result);
        return result;
    }

    public int divide(int a, int b) {
        logger.log("Dividing " + a + " by " + b);
        if (b == 0) {
            logger.log("Attempted divide by zero");
            throw new IllegalArgumentException("Division by zero");
        }
        int result = a / b;
        logger.log("The result is " + result);
        return result;
    }
}
