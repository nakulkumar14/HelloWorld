package LLDProblems.LLDVendingMachine;

import LLDProblems.LLDVendingMachine.state.IdleStateImpl;
import LLDProblems.LLDVendingMachine.state.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
  List<Coin> coinList;
  State state;

  Inventory inventory;

  public VendingMachine() {
    coinList = new ArrayList<>();
    inventory = new Inventory(10);
    state = new IdleStateImpl();
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public List<Coin> getCoinList() {
    return coinList;
  }

  public void setCoinList(List<Coin> coinList) {
    this.coinList = coinList;
  }
}
