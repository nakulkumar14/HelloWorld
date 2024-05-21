package LLDProblems.LLDLogger.model;

import LLDProblems.LLDLogger.LogObservable;

public class ErrorLogger extends AbstractLogger {
  public ErrorLogger(AbstractLogger nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level, String message, LogObservable logObservable) {
    if (level == LogLevel.ERROR) {
      System.out.println("ERROR : " + message);
      logObservable.notifyObservers(level.getLevel(), message);
    } else {
      super.log(level, message, logObservable);
    }
  }
}