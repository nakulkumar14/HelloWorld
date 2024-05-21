package LLDProblems.LLDLogger.model;

import LLDProblems.LLDLogger.LogObservable;

public class WarnLogger extends AbstractLogger {
  public WarnLogger(AbstractLogger nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level, String message, LogObservable logObservable) {
    if (level == LogLevel.WARN) {
      System.out.println("WARN : " + message);
      logObservable.notifyObservers(level.getLevel(), message);
    } else {
      super.log(level, message, logObservable);
    }
  }
}