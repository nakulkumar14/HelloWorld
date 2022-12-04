package com.company.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Drink {
  void drink();
}

class SoftDrink implements Drink {

  @Override
  public void drink() {
    System.out.println("soft drink");
  }
}

class HardDrink implements Drink {

  @Override
  public void drink() {
    System.out.println("hard drink");
  }
}

class Drinks implements Drink {

  List<Drink> drinks = new ArrayList<>();

  @Override
  public void drink() {
    for (Drink drink : drinks) {
      drink.drink();
    }
  }

  public void addDrink(Drink drink) {
    drinks.add(drink);
  }

  public void remove(Drink drink) {
    drinks.remove(drink);
  }
}

public class CompositePattern {
  public static void main(String[] args) {
    Drinks drinks = new Drinks();
    SoftDrink softDrink = new SoftDrink();
    drinks.addDrink(softDrink);
    drinks.addDrink(new HardDrink());
    drinks.addDrink(new HardDrink());

    drinks.drink();
    drinks.remove(softDrink);
    System.out.println("====");
    drinks.drink();
  }
}
