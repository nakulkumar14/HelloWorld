package com.company.designpattern;

abstract class Vehicle {
  abstract void type();
}

class Bike extends Vehicle {

  @Override
  void type() {
    System.out.println("2 wheeler");
  }
}

class Car extends Vehicle {
  @Override
  void type() {
    System.out.println("4 wheeler");
  }
}

class VehicleFactory {
  public static Vehicle getVehicle(String type) {
    if (type == "bike") {
      return new Bike();
    } else {
      return new Car();
    }
  }
}

public class FactoryPattern {
  public static void main(String[] args) {
    Vehicle bike = VehicleFactory.getVehicle("bike");
    Vehicle car = VehicleFactory.getVehicle("car");
    bike.type();
    car.type();
  }
}
