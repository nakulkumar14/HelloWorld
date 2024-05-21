package LLDProblems.LLDVendingMachine.state;

import LLDProblems.LLDVendingMachine.Coin;
import LLDProblems.LLDVendingMachine.VendingMachine;

import java.util.List;

public interface SelectionState extends State {

  void pressProductSelectionButton();

  void selectProduct(VendingMachine vendingMachine, int code) throws Exception;

  List<Coin> refundFullMoney(VendingMachine vendingMachine);

  int getChange(int refundExtraMoney);

}
