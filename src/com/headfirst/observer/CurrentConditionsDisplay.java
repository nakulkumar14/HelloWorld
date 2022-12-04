package com.headfirst.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

  float temp;
  float humidity;
  float pressure;
  Subject subject;

  public CurrentConditionsDisplay(WeatherData weatherData) {
    this.subject = weatherData;
    subject.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Current temp details : " + temp + ", " + humidity + ", " + pressure);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    display();
  }
}
