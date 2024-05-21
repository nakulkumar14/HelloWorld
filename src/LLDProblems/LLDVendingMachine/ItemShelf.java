package LLDProblems.LLDVendingMachine;

public class ItemShelf {
  private Item item;
  private int code;
  private boolean soldOut;

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean isSoldOut() {
    return soldOut;
  }

  public void setSoldOut(boolean soldOut) {
    this.soldOut = soldOut;
  }

  public ItemShelf(Item item, int code, boolean soldOut) {
    this.item = item;
    this.code = code;
    this.soldOut = soldOut;
  }
}
