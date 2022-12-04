package com.headfirst.ducks;

public class MallardDuck extends Duck{

  MallardDuck() {
    quackBehaviour = new Quack();
    flyBehaviour = new FlyWithWings();
  }

  @Override
  void display() {
    System.out.println("I am mallard duck");
  }
}
