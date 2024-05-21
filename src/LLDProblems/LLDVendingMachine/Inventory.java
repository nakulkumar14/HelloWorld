package LLDProblems.LLDVendingMachine;

public class Inventory {
  ItemShelf[] inventory = null;

  public Inventory(int itemCount) {
    inventory = new ItemShelf[itemCount];
    initialEmptyInventory();
  }

  private void initialEmptyInventory() {
    int code = 101;
    for (int i = 0; i < inventory.length; i++) {
      ItemShelf itemShelf = new ItemShelf(null, code, true);
      inventory[i] = itemShelf;
      code++;
    }
  }

  public void addItem(Item item, int code) throws Exception {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == code) {
        if (itemShelf.isSoldOut()) {
          itemShelf.setItem(item);
          itemShelf.setSoldOut(false);
        } else {
          throw new Exception("Item already present.");
        }
      }
    }
  }

  public Item getItem(int code) throws Exception {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == code) {
        if (itemShelf.isSoldOut()) {
          throw new Exception("Item sold out.");
        } else {
//          itemShelf.setSoldOut(true);
          return itemShelf.getItem();
        }
      }
    }
    throw new Exception("Invalid item code");
  }

  public void updateItemSoldOut(int code) {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == code) {
        itemShelf.setSoldOut(true);
      }
    }
  }

  public ItemShelf[] getInventory() {
    return inventory;
  }

  public void setInventory(ItemShelf[] inventory) {
    this.inventory = inventory;
  }
}
