package LLDProblems.LLDLogger.model;

import LLDProblems.LLDLogger.LogObservable;

public class AbstractLogger {

  private AbstractLogger nextLogProcessor;

  public AbstractLogger(AbstractLogger nextLogProcessor) {
    this.nextLogProcessor = nextLogProcessor;
  }

  public void log(LogLevel level, String message, LogObservable logObservable) {
    if (nextLogProcessor != null) {
      nextLogProcessor.log(level, message, logObservable);
    }
  }

}
