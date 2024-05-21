package LLDProblems.LLDLogger;

import LLDProblems.LLDLogger.model.AbstractLogger;
import LLDProblems.LLDLogger.model.LogLevel;

public class Logger implements Cloneable {
  private static Logger logger;
  private static AbstractLogger chainOfLogger;

  private static LogObservable logObservable;

  private Logger() {
    if (logger != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  public static Logger getLogger() {
    if (logger == null) {
      synchronized (Logger.class) {
        if (logger == null) {
          logger = new Logger();
          chainOfLogger = LogManager.buildChainOfLoggers();
          logObservable = LogManager.buildSubject();

        }
      }
    }
    return logger;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  private void display(LogLevel level, String message) {
    chainOfLogger.log(level, message, logObservable);
  }

  public void debug(String message) {
    display(LogLevel.DEBUG, message);
  }

  public void info(String message) {
    display(LogLevel.INFO, message);
  }

  public void warn(String message) {
    display(LogLevel.WARN, message);
  }

  public void error(String message) {
    display(LogLevel.ERROR, message);
  }

}
