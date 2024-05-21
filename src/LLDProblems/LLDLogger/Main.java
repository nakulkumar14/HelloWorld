package LLDProblems.LLDLogger;

// https://www.youtube.com/watch?v=gvIn5QBdGDk&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=13
// https://www.youtube.com/watch?v=RljSBrZeJ3w
public class Main {
  public static void main(String[] args) {
//    DebugLogger logger = new DebugLogger(new InfoLogger(new WarnLogger(new ErrorLogger(null))));

    Logger logger = Logger.getLogger();

    logger.debug("This is debug message");
    logger.info("This is info message");
    logger.warn("This is warn message");
    logger.error("This is error message");
  }
}
