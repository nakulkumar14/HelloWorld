package com.company.designpattern;

class Currency {
  int amount;

  public Currency(int amount) {
    this.amount = amount;
  }
}

interface Dispense {
  void setNextChain(Dispense dispense);
  void dispense(Currency currency);
}

class Dispense100 implements Dispense{

  private Dispense nextDispenser;

  @Override
  public void setNextChain(Dispense dispense) {
    this.nextDispenser = dispense;
  }

  @Override
  public void dispense(Currency currency) {
    if (currency.amount >= 100) {
      int q = currency.amount / 100;
      System.out.println(q + " 100 Rs notes.");
      int r = currency.amount % 100;
      if (r!=0) {
        this.nextDispenser.dispense(new Currency(r));
      }
    } else {
//      this.nextDispenser.dispense(currency);
      System.out.println("Cannot dispense Rs. " + currency.amount);
    }
  }
}

class Dispense200 implements Dispense{

  private Dispense nextDispenser;

  @Override
  public void setNextChain(Dispense dispense) {
    this.nextDispenser = dispense;
  }

  @Override
  public void dispense(Currency currency) {
    if (currency.amount >= 200) {
      int q = currency.amount / 200;
      System.out.println(q + " 200 Rs notes, ");
      int r = currency.amount % 200;
      if (r!=0) {
        this.nextDispenser.dispense(new Currency(r));
      }
    } else {
      this.nextDispenser.dispense(currency);
    }
  }
}

class Dispense500 implements Dispense{

  private Dispense nextDispenser;

  @Override
  public void setNextChain(Dispense dispense) {
    this.nextDispenser = dispense;
  }

  @Override
  public void dispense(Currency currency) {
    if (currency.amount >= 500) {
      int q = currency.amount / 500;
      System.out.println(q + " 500 Rs notes, ");
      int r = currency.amount % 500;
      if (r!=0) {
        this.nextDispenser.dispense(new Currency(r));
      }
    } else {
      this.nextDispenser.dispense(currency);
    }
  }
}

class ATMDispenser {

  private Dispense500 dispense500;

  public ATMDispenser() {
    dispense500 = new Dispense500();
    Dispense200 dispense200 = new Dispense200();
    Dispense100 dispense100 = new Dispense100();

    dispense500.setNextChain(dispense200);
    dispense200.setNextChain(dispense100);
  }

  public void dispense(int amount) {
    Currency currency = new Currency(amount);
    dispense500.dispense(currency);
  }
}

public class ChainOfResponsibility {
  public static void main(String[] args) {
    ATMDispenser atmDispenser = new ATMDispenser();
    atmDispenser.dispense(1500);
    System.out.println("===============");
    atmDispenser.dispense(1200);
    System.out.println("===============");
    atmDispenser.dispense(1800);
    System.out.println("===============");
    atmDispenser.dispense(250);
  }
}
