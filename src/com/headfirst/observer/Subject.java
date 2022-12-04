package com.headfirst.observer;

public interface Subject {
  void registerObserver(Observer o);

  void removeObserver(Observer o);

  void notifyObserver();
}
