package com.test;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Reorderlist {

  public static void main(String[] args) {
    Reorderlist o = new Reorderlist();
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    list.next.next.next = new ListNode(4);
    o.reorderList(list);

    System.out.println("Ans : ");
    o.print(list);
  }

  public void reorderList(ListNode head) {
    // Reverse from mid of list
    // pick and add in result list one by one
    ListNode mid;
    ListNode slow = head, fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }


    ListNode temp = null;
    // even nodes
    if (fast == null) {
      //reverse after prev
      prev.next = null;
      temp = reverse(slow);
    } else {
      // odd nodes
      // reverse after slow
      prev.next = null;
      temp = reverse(slow);
    }

//    print(head);
//    print(temp);

    ListNode ans = new ListNode(0);
    ListNode temp1 = ans;
    while (head != null && temp != null) {
      temp1.next = head;
      temp1 = temp1.next;
      head = head.next;

      temp1.next = temp;
      temp1 = temp1.next;
      temp = temp.next;

      print(temp1);
    }

//      head = head.next;
//      temp = temp.next;
//    }
//
//    if (head != null) {
//      temp1.next = head;
//      temp1 = temp1.next;
//    }
//
//    if (temp != null) {
//      temp1.next = temp;
//      temp.next = null;
//    }
//
//    head = ans.next;
  }

  ListNode reverse(ListNode head) {
    ListNode a = head, b, c = null;
    while (a != null) {
      b = a;
      a = a.next;
      b.next = c;
      c = b;
    }
    return c;
  }

  void print(ListNode head) {
    System.out.print("List : ");
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}