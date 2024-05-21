package LLDProblems.LLDLogger;

import LLDProblems.LLDLogger.model.*;

public class LogManager {
  public static AbstractLogger buildChainOfLoggers() {
    AbstractLogger logger = new DebugLogger(new InfoLogger(new WarnLogger(new ErrorLogger(null))));
    return logger;
  }

  public static LogObservable buildSubject() {

    LogObservable observable = new LogSubject();
    ConsoleLogger consoleLogger = new ConsoleLogger();
    FileLogger fileLogger = new FileLogger();
//    DBLogger dbLogger = new DBLogger();
    observable.addObserver(LogLevel.DEBUG.getLevel(), consoleLogger);
    observable.addObserver(LogLevel.DEBUG.getLevel(), fileLogger);

    observable.addObserver(LogLevel.INFO.getLevel(), fileLogger);
//    observable.addObserver(3, dbLogger);
    return  observable;
  }
}
