package LLDProblems.LLDLogger.model;

import LLDProblems.LLDLogger.LogObservable;

public class DebugLogger extends AbstractLogger{
  public DebugLogger(AbstractLogger nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level, String message, LogObservable logObservable) {
    if (level == LogLevel.DEBUG) {
      System.out.println("DEBUG : " + message);
      logObservable.notifyObservers(level.getLevel(), message);
    } else {
      super.log(level, message, logObservable);
    }
  }
}
