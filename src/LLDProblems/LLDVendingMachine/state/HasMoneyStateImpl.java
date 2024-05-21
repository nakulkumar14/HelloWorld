package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.Coin;
import LLDProblems.LLDVendingMachine.VendingMachine;

import java.util.List;

public class HasMoneyStateImpl implements HasMoney{
  public HasMoneyStateImpl() {
    System.out.println("Currently machine in HASMONEY state.");
  }


  @Override
  public void selectProduct(VendingMachine vendingMachine) {
    vendingMachine.setState(new SelectionStateImpl());
  }

  @Override
  public void insertCoin(VendingMachine vendingMachine, Coin coin) {
    System.out.println("Accepted coin : " + coin);
    vendingMachine.getCoinList().add(coin);
  }

  @Override
  public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
    System.out.println("Refunded full money.");
    vendingMachine.setState(new IdleStateImpl(vendingMachine));
    return vendingMachine.getCoinList();
  }
}
