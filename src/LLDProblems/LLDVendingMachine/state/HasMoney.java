package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.Coin;
import LLDProblems.LLDVendingMachine.VendingMachine;

import java.util.List;

public interface HasMoney extends State{

  void selectProduct(VendingMachine vendingMachine);

  void insertCoin(VendingMachine vendingMachine, Coin coin);

  List<Coin> refundFullMoney(VendingMachine vendingMachine);
}
