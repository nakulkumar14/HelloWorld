package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.Coin;
import LLDProblems.LLDVendingMachine.Item;
import LLDProblems.LLDVendingMachine.VendingMachine;

import java.util.List;

public class SelectionStateImpl implements SelectionState {
  public SelectionStateImpl() {
    System.out.println("Currently machine in product selection state.");
  }

  public void pressProductSelectionButton() {
    System.out.println("Select product.");
  }

  @Override
  public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {
    Item item = vendingMachine.getInventory().getItem(code);

    int paid = 0;
    for (Coin coin : vendingMachine.getCoinList()) {
      paid += coin.value;
    }

    if (item.getPrice() <= paid) {
      vendingMachine.setState(new DispenseStateImpl(vendingMachine, code));
      if (item.getPrice() < paid) {
        getChange(paid - item.getPrice());
      }
    } else {
      System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paid);
      refundFullMoney(vendingMachine);
      throw new Exception("Insufficient money");
    }


  }

  @Override
  public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
    System.out.println("Refunded full money.");
    vendingMachine.setState(new IdleStateImpl(vendingMachine));
    return vendingMachine.getCoinList();
  }

  @Override
  public int getChange(int refundExtraMoney) {
    System.out.println("Refunded extra money in tray. : " + refundExtraMoney);
    return refundExtraMoney;
  }
}
