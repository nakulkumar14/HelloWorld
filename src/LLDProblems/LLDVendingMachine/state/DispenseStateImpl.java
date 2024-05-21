package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.Item;
import LLDProblems.LLDVendingMachine.VendingMachine;

public class DispenseStateImpl implements DispenseState{
  public DispenseStateImpl(VendingMachine vendingMachine, int code) throws Exception {
    System.out.println("Currently machine in Dispensing state.");
    dispenseProduct(vendingMachine, code);
  }

  public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
    System.out.println("Item dispensed");
    Item item = vendingMachine.getInventory().getItem(code);
    vendingMachine.getInventory().updateItemSoldOut(code);
    vendingMachine.setState(new IdleStateImpl());
    return item;
  }


}
