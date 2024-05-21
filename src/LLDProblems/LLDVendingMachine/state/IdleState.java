package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.VendingMachine;

public interface IdleState extends State{
  void pressInsertCoinButton(VendingMachine vendingMachine);
}
