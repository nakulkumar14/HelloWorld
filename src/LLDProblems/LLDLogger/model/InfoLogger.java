package LLDProblems.LLDLogger.model;

import LLDProblems.LLDLogger.LogObservable;

public class InfoLogger extends AbstractLogger {
  public InfoLogger(AbstractLogger nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level, String message, LogObservable logObservable) {
    if (level == LogLevel.INFO) {
      System.out.println("INFO : " + message);
      logObservable.notifyObservers(level.getLevel(), message);
    } else {
      super.log(level, message, logObservable);
    }
  }
}