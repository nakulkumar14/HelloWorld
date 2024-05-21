package LLDProblems.LLDLogger;

public class DBLogger implements LogObserver {
  @Override
  public void log(String message) {
    System.out.println("DB : " + message);
  }
}