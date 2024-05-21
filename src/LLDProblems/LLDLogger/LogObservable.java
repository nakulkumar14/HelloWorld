package LLDProblems.LLDLogger;

public interface LogObservable {
  public void addObserver(int level, LogObserver logObserver);

  public void notifyObservers(int level, String message);
}
