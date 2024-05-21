package LLDProblems.LLDLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject implements LogObservable {
  Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

  @Override
  public void addObserver(int level, LogObserver logObserver) {
    List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
    logObserverList.add(logObserver);
    logObservers.put(level, logObserverList);
  }

  @Override
  public void notifyObservers(int level, String message) {
    List<LogObserver> logObserverList = logObservers.get(level);
    if (logObserverList != null) {
      for (LogObserver logObserver : logObserverList) {
        logObserver.log(message);
      }
    }
  }
}
