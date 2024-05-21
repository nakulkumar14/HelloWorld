package LLDProblems.LLDVendingMachine;

import LLDProblems.LLDVendingMachine.state.HasMoneyStateImpl;
import LLDProblems.LLDVendingMachine.state.IdleStateImpl;
import LLDProblems.LLDVendingMachine.state.SelectionStateImpl;

public class Main {
  public static void main(String[] args) throws Exception {
    VendingMachine vendingMachine = new VendingMachine();
    System.out.println("Filling inventory");
    fillInventory(vendingMachine);
    displayInventory(vendingMachine);

    System.out.println("Click on insertion button");
    IdleStateImpl idleState = (IdleStateImpl) vendingMachine.getState();
    idleState.pressInsertCoinButton(vendingMachine);

    HasMoneyStateImpl hasMoneyState = (HasMoneyStateImpl) vendingMachine.getState();
    hasMoneyState.insertCoin(vendingMachine, Coin.FIVE);
    hasMoneyState.insertCoin(vendingMachine, Coin.TEN);

    hasMoneyState.selectProduct(vendingMachine);
    System.out.println("Click on product selection button");
    SelectionStateImpl selectionState = (SelectionStateImpl) vendingMachine.getState();
    selectionState.selectProduct(vendingMachine, 102);

    displayInventory(vendingMachine);
  }

  private static void displayInventory(VendingMachine vendingMachine) {
    ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
    for (ItemShelf itemShelf : inventory) {
      System.out.println("Code : " + itemShelf.getCode()
          + "Item : " + itemShelf.getItem()
          + "Price : " + itemShelf.getItem().getPrice()
          + "Available : " + itemShelf.isSoldOut()
      );
    }
  }

  private static void fillInventory(VendingMachine vendingMachine) {
    ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
    for (int i = 0; i < inventory.length; i++) {
      Item item = new Item();
      if (i < 3) {
        item.setItemType(ItemType.COKE);
        item.setPrice(12);
      } else if (i >= 3 && i < 5) {
        item.setItemType(ItemType.PEPSI);
        item.setPrice(15);
      } else if (i >= 5 && i < 7) {
        item.setItemType(ItemType.SODA);
        item.setPrice(10);
      } else if (i >= 7 && i < 10) {
        item.setItemType(ItemType.WATER);
        item.setPrice(20);
      }

      inventory[i].setItem(item);
      inventory[i].setSoldOut(false);
    }
  }
}
