package com.headfirst.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
  float temp;
  float humidity;
  float pressure;
  List<Observer> observerList;

  public WeatherData() {
    this.observerList = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer o) {
    observerList.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observerList.remove(o);
  }

  @Override
  public void notifyObserver() {
    observerList.forEach(observer -> observer.update(temp, humidity, pressure));
  }

  public void measurementsChanged() {
    notifyObserver();
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
