package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/microsoft-interview-experience-4-years-experienced-2/?ref=rp
 * <p>
 * Then he ask me to design the data structure such we can perform operation
 * insertFirst(value):- value inserted head of the list Time Complexity O(1)
 * insertLast(value):- value inserted last of the list Time Complexity O(1)
 * deleteValue(val):- delete the value from the list if the list contains multiple values then it should delete only first occurrence expected time complexity O(1).
 * isExist(value):- return the true if value exist in the data structure otherwise false, expected time complexity O(1)
 * Write the code for the above problem using the best data structure and cover all test case, almost 1 hrs. Complete to solve this problem
 */
class CNode {
  int data;
  CNode next;
  CNode prev;

  public CNode(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class CustomDS {
  private CNode head, tail;
  private Map<Integer, List<CNode>> map;

  public CustomDS() {
    this.head = new CNode(0);
    this.tail = new CNode(0);
    this.map = new HashMap<>();

    head.next = tail;
    tail.prev = head;
  }

  void show() {
    CNode temp = head.next;
    while (temp != tail) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  void insertFirst(int value) {
    CNode temp = new CNode(value);
    temp.next = head.next;
    head.next.prev = temp;

    head.next = temp;
    temp.prev = head;

    if (!map.containsKey(value)) {
      map.put(value, new ArrayList<>());
    }
    map.get(value).add(0, temp);
  }

  void insertLast(int value) {
    CNode temp = new CNode(value);
    temp.prev = tail.prev;
    tail.prev.next = temp;

    temp.next = tail;
    tail.prev = temp;

    if (!map.containsKey(value)) {
      map.put(value, new ArrayList<>());
    }
    map.get(value).add(temp);
  }

  void deleteValue(int value) {
    if (map.containsKey(value)) {
      CNode temp = map.get(value).get(0);
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
      int size = map.get(value).size();
      if (size == 1) {
        map.remove(value);
      } else {
        map.get(value).remove(0);
      }
    }
  }

  boolean isExist(int value) {
    return map.containsKey(value);
  }
}

public class ConstantTimeDS {
  public static void main(String[] args) {
    CustomDS ds = new CustomDS();
    ds.insertFirst(1);
    ds.insertLast(2);
    ds.insertLast(3);
    ds.insertFirst(4);
    ds.show();
    System.out.println(ds.isExist(5));
    System.out.println(ds.isExist(1));
    ds.deleteValue(2);
    ds.show();
    ds.insertFirst(1);
    ds.insertLast(3);
    ds.show();
    ds.deleteValue(1);
    ds.show();
    ds.deleteValue(1);
    ds.show();
  }
}
