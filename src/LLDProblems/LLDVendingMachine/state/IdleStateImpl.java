package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.VendingMachine;

import java.util.ArrayList;

public class IdleStateImpl implements IdleState{

  public IdleStateImpl() {
    System.out.println("Currently machine in IDLE state.");
  }

  public IdleStateImpl(VendingMachine vendingMachine) {
    System.out.println("Currently machine in IDLE state.");
    vendingMachine.setCoinList(new ArrayList<>());
  }

  public void pressInsertCoinButton(VendingMachine vendingMachine) {
    vendingMachine.setState(new HasMoneyStateImpl());
  }
}
