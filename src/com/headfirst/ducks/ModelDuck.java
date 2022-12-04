package com.headfirst.ducks;

public class ModelDuck extends Duck{

  ModelDuck() {
    flyBehaviour = new FlyNoWay();
    quackBehaviour = new Quack();
  }

  @Override
  void display() {
    System.out.println("I am model duck");
  }
}
